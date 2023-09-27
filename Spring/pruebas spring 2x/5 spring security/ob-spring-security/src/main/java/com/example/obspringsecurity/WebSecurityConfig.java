package com.example.obspringsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

@Configuration
@EnableWebSecurity  // funciona para configurar spring security
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                //se puede cofigurar de que el usuario tenga determinado rol, autoridad o ip
                .antMatchers("/hola").permitAll() //hace Match contra una serie de URL que cumplan determinado formato, permit Permite las peticiones contra esas URLs
                .antMatchers("/hola").hasRole("ADMIN ")
                .anyRequest().authenticated() //todas las demas peticiones tienen que estar autenticadas, tiene que loguearse
                .and().formLogin()
                .and().httpBasic();
    }

    // firewall configura si se pueden habilitar ciertos caracteres en la URL, por ejemplo ";" "/" esto se puede evitar, escapar caracteres, por defecto viene definido
    @Bean //genera un Bean de tipo HttpFirewall y sobreescriba el que ya tiene spring Security
    public HttpFirewall looseHttpFirewall(){
        StrictHttpFirewall firewall = new StrictHttpFirewall();
        firewall.setAllowBackSlash(true);//si necesitamos enviar un caracter especial que el firewall por defecto esta bloqueando
        firewall.setAllowSemicolon(true);//permite el paso de esa llamada ;bootstrap, retorna un 404 porque no tengo ;bootstrap configurado, ya no devuelve un error en consola
        firewall.setAllowUrlEncodedSlash(true);
        return firewall;
    }

    //permite modificar el sistema de autenticacion, creamos los usuarios desde aqui
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //habilita un usuario en memoria, se puede usar un .passwordEnconder() que codifica las contraseñas con un algoritmo fuerte
        auth.inMemoryAuthentication() //auth parametro que recibe
                .passwordEncoder(passwordEncoder())
                .withUser("user").password(passwordEncoder().encode("password")).roles("USER")
                .and()
                .withUser("admin").password(passwordEncoder().encode("password")).roles("USER", "ADMIN");
        //nota se puede cambiar usua y contra en application.properties con spring.security.user.name y spring.security.user.password
    }   //nota se puede añadir un usuario con un rol o contraseña fija, se puede con BD pero es mas compleja de implementar

    @Bean
    public PasswordEncoder passwordEncoder(){
       return new BCryptPasswordEncoder();
    }
//    @Override
//    public UserDetailsService userDetailsServiceBean() throws Exception {
//        return super.userDetailsServiceBean();
//    }
}
