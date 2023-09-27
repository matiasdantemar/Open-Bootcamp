
package com.example.obspringsecurityjwtroles.config;

import com.example.obspringsecurityjwtroles.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


// Punto principal, corazon de la seguridad se define aqui

/**
 * Clase para la configuración de seguridad Spring Security
 */
@Configuration // indica que esta clase es de configuracion, va a tener metodos que van a estar marcados con la anotacion @Bean
@EnableWebSecurity // permite a Spring aplicar esta configuracion a la configuracion de seguridad global
@EnableGlobalMethodSecurity(prePostEnabled = true)
//@RequiredArgsConstructor
public class WebSecurityConfig {
//    @Autowired
//    private UserServiceImpl userDetailsService;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private UnauthorizedEntryPoint unauthorizedEntryPoint;

    @Autowired
    private CustomAccessDeniedHandler accessDeniedHandler;

//    @Autowired
//    TokenProvider jwtTokenUtil;

    AuthenticationManager authenticationManager;


//    la clase CustomAccessDeniedHandler al tener la anotacion @Component ya no hace falta usar el @Bean en su caso usamos @Autowired
//    @Bean
//    public CustomAccessDeniedHandler accessDeniedHandler(){
//        return new CustomAccessDeniedHandler();
//    }

//     @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//
//        authProvider.setUserDetailsService(userDetailsService);
//        authProvider.setPasswordEncoder(encoder());
//
//        return authProvider;
//    }

    @Bean  //este ya lo hice cuando empece seguridad por primera vez, solo que incorpore mas cosas
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception { //va a tener toda la cadena de filtros que se va a ir ejecutando
        http
                .csrf(AbstractHttpConfigurer::disable) // Cross-Site Request Forgery CSRF
                .cors(AbstractHttpConfigurer::disable) // CORS (Cross-origin resource sharing)
                .authorizeHttpRequests(auth ->
                        auth.requestMatchers("/users/authenticate", "/users/register").permitAll()
                                .anyRequest().authenticated()) //el resto tiene que estar autenticada

                .exceptionHandling(exception -> exception //permite agregar "objetos" authenticationEntryPoint, accessDeniedHandler, que sobreescriben la gestion de errores
                        .authenticationEntryPoint(unauthorizedEntryPoint) //para gestion de excepciones, unauthorizedEntryPoint pertenece a una clase mia
                        .accessDeniedHandler(accessDeniedHandler)) //configuramos como se van a gestionar las exepciones, se le puede poner anotacion
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)); // para indicar que no quiero que no haya sesion

//        http.authenticationProvider(authenticationProvider());
        http.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    //OTRA FORMA
//    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(AbstractHttpConfigurer::disable)
//                .cors(AbstractHttpConfigurer::disable)
//                .exceptionHandling(exception -> exception
//                        .authenticationEntryPoint(unauthorizedEntryPoint)
//                        .accessDeniedHandler(accessDeniedHandler))
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/users/authenticate", "/users/register").permitAll()
//                        .anyRequest().authenticated());
//
//        http.authenticationProvider(authenticationProvider());
//        http.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
//
//        return http.build();
//    }

    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public JwtAuthenticationFilter authenticationTokenFilterBean() throws Exception {
        return new JwtAuthenticationFilter();
    }
}