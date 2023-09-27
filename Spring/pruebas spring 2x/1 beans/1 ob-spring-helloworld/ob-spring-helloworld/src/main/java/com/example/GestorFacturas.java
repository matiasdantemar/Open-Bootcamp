package com.example;

public class GestorFacturas {
    Calculadora calculadora;
    String nombre;
    public GestorFacturas(Calculadora calculadora, String nombre){
        System.out.println("Ejecutando constructor GestorFacturas");
        this.calculadora = calculadora;
        this.nombre = nombre;
    }
}
