package com.example.springpatterns.patterns.structural.adapter;


// Adapta un objeto que a priori es incompatible con otros objetos con los que estoy trabajando

public class Main {
	
	public static void main(String[] args) {
		
        Movable toyota = new Car();
        toyota.speedUp(50);
        
//        Movable johndeere = new Tractor();
//        johndeere.speedUp(50);
        
        Movable tractor = new TractorAdapter();
        tractor.speedUp(50);
        
	}

}
