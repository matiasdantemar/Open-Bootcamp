package com.example.springpatterns.patterns.structural.decorator;

import com.example.springpatterns.patterns.structural.decorator.decoradores.EffectRetro;
import com.example.springpatterns.patterns.structural.decorator.decoradores.EffectVintage;

// agrega nuevas funcionalidades
// ejemplo en Spring Security en Programacion Orientada a Aspectos y aplicamos seguridad de tipo transversal, se evalua en paralelo, cuando llega una peticion lo intercepta se
// evalua la funcionalidad y si todo funciona se lleva a cabo
// Ejemplo en las auditorias, toda operacion que ocurra se le agrega una decoracion que simplemente es que tiene que imprimir en unos archivos de log lo que esta pasando, habran unas
// clases especiales que van a interceptar todo lo que ocurre y van a escribirlo en un archivo para que quede constancia de lo que ha ocurrido, sirve para hacer auditoria,
// monitorizacion, ver que se esta ejecutando en la aplicacion, que metodos java son los que mas se invocan, que parametros son los que reciben etc.
// tengo el metodo guardar a ese metodo le agrego una fase extra, no lo programo en el metodo iria por fuera, esa fase extra guardaria en un archivo lo que ocurrio

public class Main {

	public static void main(String[] args){
//objeto selfie el cual le aplico un decorador, a su vez al resultado le aplico otro decorador y asi me va quedando un objeto complejo con mas funcionalidades, le agrego por fuera elementos

		// Se crea la foto original
		Photo selfie = new DigitalPhoto(); // tengo una foto original en la cual no tengo nada todavia,
		System.out.println(selfie.show());


		System.out.println("=====================");
		// Se aplica un decorador a la foto orignial, EffectRetro es el constructor del decorador recibe un objeto Photo
		Photo selfieRetro = new EffectRetro(selfie); //esa foto se envuelve en un decorador y en consecuencia adquirira unos cambios en sus atributos y aumentara o disminuira su coste
		System.out.println(selfieRetro.show()); // Decora la funcionalidad show original

		System.out.println("=====================");
		Photo selfieVintage = new EffectVintage(selfie); // se pueden crear diferentes fotos con filtros
		System.out.println(selfieVintage.show());

		System.out.println("=====================");
		//crea un decorador que envuelva a otro decorador y que envuelve a su vez la foto original, eso se puede porque los decoradores extienden de Photo, son tomados como fotos
		Photo selfieRetroVintage = new EffectRetro(new EffectVintage(selfie)); // esta foto se le agrega DOS filtros, la decoro dos veces de diferente manera
		System.out.println(selfieRetroVintage.show());
		
		System.out.println("fin");
	}

// Ejemplo cuando tenemos cualquier aplicacion de edicion de fotos, le meto un filtro y luego esa foto la guardo y le meto otro filtro encima, seria la misma mecanica pero desde java
}
