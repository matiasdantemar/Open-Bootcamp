package com.example;

import org.springframework.stereotype.Component;

@Component
public class Calculadora {

    public Calculadora(){
        System.out.println("Ejecutando constructor calculadora");
    }
    public String holaMundo(){
        return "Hola Mundo!";
    }
}
