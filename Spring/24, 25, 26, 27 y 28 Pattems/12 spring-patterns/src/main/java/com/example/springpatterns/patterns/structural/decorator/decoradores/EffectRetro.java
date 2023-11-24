package com.example.springpatterns.patterns.structural.decorator.decoradores;

import com.example.springpatterns.patterns.structural.decorator.Photo;

// agregamos decoradores, que modifican las propiedades brillo, contraste, etc
public class EffectRetro extends PhotoDecorator{

	public EffectRetro(Photo photo) {
		super(photo);
	}

	@Override
	public String show() {
		System.out.println("Ejecutando metodo show de Decorador EffectRetro");
		// decorar la foto
		this.photo.setBrightness(50); //cambia brillo
		this.photo.setContrast(20); //cambia contraste
		return this.photo.show() + " + Retro"; //agrega el texto " + Retro"
	}
	
	@Override
	public double cost() {
		return this.photo.cost() + 20;
	} //suma +20

}
