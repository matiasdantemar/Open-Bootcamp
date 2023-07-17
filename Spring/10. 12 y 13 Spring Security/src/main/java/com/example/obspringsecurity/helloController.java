package com.example.obspringsecurity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloController {

    @Value("${app.message}")
    private String message;

    @GetMapping("/hola")
    public String hola(){
        return message;
    }

}
