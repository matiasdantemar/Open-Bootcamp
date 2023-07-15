package com.example.ordenadores.controller;


import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("api/hola")
    public String hola(@RequestHeader HttpHeaders headers) {
        System.out.println(headers.get("User-Agent"));
        return "hola";
    }
}
