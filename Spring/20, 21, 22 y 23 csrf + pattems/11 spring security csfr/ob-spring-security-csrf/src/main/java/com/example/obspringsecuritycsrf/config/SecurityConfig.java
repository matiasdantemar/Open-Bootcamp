package com.example.obspringsecuritycsrf.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("user")
                .roles("USER")
                .build();
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception { //va a tener toda la cadena de filtros que se va a ir ejecutando
        //Por defecto, si no se especifica nada entonces la proteccion CSRF esta habilitada
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api/hola").permitAll()
                        .anyRequest().authenticated()) //el resto tiene que estar autenticada
//                .formLogin(withDefaults());
                .formLogin(form -> form //agrego formulario
                        .loginPage("/login")
                        .permitAll())
                .httpBasic(Customizer.withDefaults());//solo va a ser para usuario y contraseña

        return http.build();
    }


}
