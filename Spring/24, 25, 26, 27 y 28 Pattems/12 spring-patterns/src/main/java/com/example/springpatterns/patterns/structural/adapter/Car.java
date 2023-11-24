package com.example.springpatterns.patterns.structural.adapter;

// coche que implementa la interfaz, podria tener una moto que tambien implemente esa interfaz, pero cada una aceleraria de una forma u otra
public class Car implements Movable{

	private double speed;
	
	@Override
	public void speedUp(double quantity) {
		this.speed += quantity;
		
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	

}
