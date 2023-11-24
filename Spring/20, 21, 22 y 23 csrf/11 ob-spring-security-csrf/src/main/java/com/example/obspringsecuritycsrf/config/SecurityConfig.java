package com.example.obspringsecuritycsrf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf((csrf) -> csrf
                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                )
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api/hola").permitAll()
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public UserDetailsService users() {
        // The builder will ensure the passwords are encoded before saving in memory
        User.UserBuilder users = User.withDefaultPasswordEncoder();
        UserDetails user = users
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        UserDetails admin = users
                .username("admin")
                .password("password")
                .roles("USER", "ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }
}

//    @Bean
//    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception { //va a tener toda la cadena de filtros que se va a ir ejecutando
//        //Por defecto, si no se especifica nada entonces la proteccion CSRF esta habilitada
//        http
// //csrfTokenRepository extrae un token de csrf de las cabeceras y hace comprobaciones, similar a JWT, capa extra de seguridad para que nadie pueda hacerse pasar por ti y hacer operaciones
////                .csrf((csrf) -> csrf
////                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))//va a generar un Token csrf que envia al cliente
//                .authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers("/api/hola", "/users").permitAll()
//                        .anyRequest().authenticated()) //el resto tiene que estar autenticada
//                .formLogin(form -> form //agrego formulario
//                        .loginPage("/login")
//                        .permitAll())
//                .httpBasic(Customizer.withDefaults());//solo va a ser para usuario y contraseña
//
//        return http.build();
//    }





