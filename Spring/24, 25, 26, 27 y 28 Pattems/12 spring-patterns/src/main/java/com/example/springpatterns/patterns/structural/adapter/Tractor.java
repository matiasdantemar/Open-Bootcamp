package com.example.springpatterns.patterns.structural.adapter;

// tengo una segunda clase la cual no utiliza y no puede ser adaptada a la interfaz Movable, porque la clase a lo mejor no es mia viene de una libreria y no puedo editarla, una clase
// de spring ya que si el dia de mañana sacan una nueva version y me pisan todo mi codigo y no voy a estar mezclando mergeando mis cambios con los de ellos, al menos que la libreria
// este obsoleta y no haya mas soporte para ella y necesite desesperadamente utilizarla porque no se va a migrar a otra libreria porque el coste es enorme y me tengo que quedar con la que tenga
public class Tractor {
	
	private double speed;
	
	
	public double getSpeed() {
		return speed;
	}


	public void setSpeed(double speed) {
		this.speed = speed;
	}

// No tiene el metodo speedUp() subir velocidad, si no changeMode() cambiar modo, no tiene el metodo acelerar o subir la velocidad
	public void changeMode(int mode) {
		switch (mode) {
		case 1: // Modo turba, metodo tortuga
			this.speed = 5;
			break;
		case 2: // Modo libre, metodo libre
			this.speed = 15;
			break;

		default:
			break;
		}
		
	}


}
