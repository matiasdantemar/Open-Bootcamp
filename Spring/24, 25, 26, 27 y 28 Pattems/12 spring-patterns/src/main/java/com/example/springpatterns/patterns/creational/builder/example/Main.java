package com.example.springpatterns.patterns.creational.builder.example;

// Ejemplo se usa en clases Java StringBuilder o Calendar teniendo objetos builder asociados

import java.util.Calendar;

public class Main {
	
	public static void main(String[] args) {

		// StringBuilder permite concatenar texto uno tras otro sin tener que hacer en varias lineas, por que si creo un objeto y le agrego los valores con metodo setters, el
		// problema esta que tengo que crearla en varias lineas, al final acabo con muchas lineas para añadir setters, en cambio aqui se concatenan las llamadas y es todo mas fluido
		StringBuilder articulo = new StringBuilder().append("Hola").append(" mundo").append(30);
		
		System.out.println(articulo);


		Calendar calendar = new Calendar.Builder().setCalendarType("gregory").setDate(2021, 7, 7).build();//build se encarga por asi decirlo de construir el objeto
		
		
	}

}
