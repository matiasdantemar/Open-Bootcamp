package com.example.obspringsecurityjwtroles.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler { //AccessDeniedHandler gestiona fallo de acceso denegado

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException e) throws IOException, ServletException {

        // You can create your own repsonse here to handle method level access denied reponses..
        // Follow similar method to the bad credentials handler above.

        //Para customizar el error
        System.out.println("Ejecutando CustomAccessDeniedHandler");
        response.setStatus(HttpStatus.FORBIDDEN.value()); //FORBIDDEN estado prohibido 403
        //codigo similar al UnauthorizedEntryPoint pero mas elaborado
        response.setContentType("application/json"); //respuesta en JSON
        Map<String, Object> data = new HashMap<>();
        data.put("timestamp", new Date()); //marca de tiempo
        data.put("status",HttpStatus.FORBIDDEN.value()); //estado
        data.put("message", "Access Denied, login again!"); //mensaje
        data.put("path", request.getRequestURL().toString()); //path con una ruta
        data.put("pd", "Have a good day :)"); //aqui se puede poner cualquier mensaje
        //Lo crea como un mapa con ObjectMapper
        OutputStream out = response.getOutputStream();
        ObjectMapper mapper = new ObjectMapper(); //ObjectMapper es una clase que viene de Jackson framework se encarga de la serializacion a JSON
        mapper.writeValue(out, data); //mapper se encarga de escribir JSON en la salida
        out.flush();

    }

}