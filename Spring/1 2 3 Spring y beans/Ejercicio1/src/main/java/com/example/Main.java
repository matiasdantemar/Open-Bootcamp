package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        // Cargar el archivo de configuración de Spring
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // Obtener el bean "saludoBean"
        Saludo saludo = (Saludo) context.getBean("saludoBean");

        // Ejecutar el método imprimirSaludo
        saludo.imprimirSaludo();

        // Cerrar el contexto de Spring
        context.close();

    }
}