package com.example.springpatterns.patterns.structural.facade;

// Oculta toda la complejidad para el que lo utilice le sea tan sencillo como simplemente decir dame un SmartPhone
// Ejemplo el mismo IntelliJ cuando abrimos un proyecto por primera vez se hacen un monton de operaciones, indexando cosas,lee la estructura, detectando que tipo de archivos son,
// si esta utilizando framework, libreria etc,lo que esta haciendo es preparar todo para que este  disponible, La fachada seria lo mismo esa idea.

// Oculta un sistema que es muy complejo, un SmartPhone es un sistema que esta compuesto por muchas piezas, aqui llamamos a la fachada pidiendole un SmartPhone, ya encendido, funcionando
// si vamos a la Facade la clase SmartPhoneFacade

import com.example.springpatterns.patterns.structural.facade.pieces.SmartPhone;

public class Main {
	
	public static void main(String[] args) {
		
		// crear un smartphone
		SmartPhone oneplus = SmartPhoneFacade.startSmartPhone();
	}

}
