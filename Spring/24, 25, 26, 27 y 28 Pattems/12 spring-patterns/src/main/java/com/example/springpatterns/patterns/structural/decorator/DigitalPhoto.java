package com.example.springpatterns.patterns.structural.decorator;

// clase original, clase foto
// clase DigitalPhoto que hereda de Photo, es la clase hija, esta obligada a implementar los metodos abstractos de Photo
public class DigitalPhoto extends Photo{

	// la foto asi normal sin decoradores ni nada escribe el texto "Normal photo without edit"
	@Override
	public String show() {
		System.out.println("Ejecutando metodo show de foto original DigitalPhoto");
		return "Normal photo without edit";
	}

	// y tiene un coste de 15, Euros, Dolares, Pesos, etc.
	@Override
	public double cost() {
		return 15;
	}


}
