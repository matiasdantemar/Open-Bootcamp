package com.example.obspringsecurityjwtroles.config;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;



@Component
public class UnauthorizedEntryPoint implements AuthenticationEntryPoint, Serializable {

    // Clase cuando se muestra un error
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response, //request y response de los Servlet
                         AuthenticationException authException) throws IOException {

        System.out.println("Ejecutando UnauthorizedEntryPoint");
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error: No autorizado"); // se crea como un error

    }

}