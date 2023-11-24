package com.example.springpatterns.patterns.structural.decorator.decoradores;

import com.example.springpatterns.patterns.structural.decorator.Photo;

//EffectVintage extiende a PhotoDecorator,
// EffectVintage es interpretado como una foto que en realidad es un decorador que envuelve a otra Photo, esto sucede en el parametro del constructor
public class EffectVintage extends PhotoDecorator{

	//constructor para llamar al construcro de arriba pasandole la foto y asociandosela
	public EffectVintage(Photo photo) {//(envuelve a otra Photo)
		super(photo);
	}

	@Override
	public String show() {
		System.out.println("Ejecutando metodo show de Decorador EffectVintage");
		// decorar la foto
		this.photo.setBrightness(90);
		this.photo.setContrast(20);
		this.photo.setBlur(5);
		return this.photo.show() + " + Vintage"; //this.photo.show() utiliza los metodos originales dela Photo
		// optimiza el metodo show de la foto original sin antes agregarle cosas (decora la foto) y le pone un texto
	}

	//le sube el coste
	@Override
	public double cost() {
		return this.photo.cost() + 15; //this.photo.cost() utiliza los metodos originales dela Photo, la sumatoria es una decoracion
	}

}
