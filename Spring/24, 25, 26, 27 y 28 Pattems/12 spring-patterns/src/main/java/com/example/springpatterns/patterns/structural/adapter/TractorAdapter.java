package com.example.springpatterns.patterns.structural.adapter;

// se crea un adapter, este patron implementa la interfaz Movable la que si tiene el metodo speedUp()

public class TractorAdapter implements Movable{

	// Internamente envuelve un tractor, adapta lo que seria el tractor al metodo speedUp()
	private Tractor tractor = new Tractor();
	
	@Override
	public void speedUp(double quantity) { // speedUp(recibe una cantidad
		// si el metodo original del tractor es changeMode() lo voy a invocar desde dentro de speedUp() haciendo las comprobaciones necesarias de velocidad
		if (this.tractor.getSpeed() + quantity < 15) { // si la cantidad + la velocidad que ya tengo es menor a 15 Modo turba
			this.tractor.changeMode(1);
		} else { // en caso contrario Modo libre
			this.tractor.changeMode(2);
		}


	}
//es una clase que sirve para adaptar, usando una funcionalidad del metodo speedUp() a el tractor, para que asi pueda trabajar con el tractor como si fuera un objeto del tipo movable
}
