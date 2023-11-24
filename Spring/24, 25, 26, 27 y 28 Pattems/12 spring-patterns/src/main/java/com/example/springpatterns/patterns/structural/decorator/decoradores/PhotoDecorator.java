package com.example.springpatterns.patterns.structural.decorator.decoradores;

import com.example.springpatterns.patterns.structural.decorator.Photo;

//el decorador es una clase abstracta que exitiende tambien de la clase abstracta Photo,
// parecido al patron adaptador, proxy, y tal, son patrones que se parecen pero no son lo mismo porque no hacen lo mismo
public abstract class PhotoDecorator extends Photo { //como el decorador extiende de Photo podria a su vez envolver a otro decorador


	//envuelve a la Foto original

	protected Photo photo; //podria ser una DigitalPhoto o un PhotoDecorator porque ambos extienden de Photo, un decorador podria tener a otro decorador, de alli se puede ir componiendo
	//objetos haciendo la decoracion como la muñeca Rusa

	protected PhotoDecorator(Photo photo) {
		super();
		this.photo = photo;
	}
	
	//esto envuelve la foto original, representando una foto en si que le llamo decorador y lo que hace a su vez es envolver a otra foto
	

}
