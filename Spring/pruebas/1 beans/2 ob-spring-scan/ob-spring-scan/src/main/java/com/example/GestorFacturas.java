package com.example;

import org.springframework.stereotype.Component;

@Component
public class GestorFacturas {
    Calculadora calculadora;

    public GestorFacturas(Calculadora calculadora){
        System.out.println("Ejecutando constructor GestorFacturas");
        this.calculadora = calculadora;
    }
}
