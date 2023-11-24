package com.example.springpatterns.patterns.creational.builder;
// patron builder o constructor
// permite concatenar diferentes llamadas con el objetivo de hacer build y poder llegar a construir un objeto
// se usa en la clase TokenProvider, se concatenan una serie de metodos que van añadiendo informacion, comienza con el meetodo builder() y termina con compact() que construye el token

public class Main {
	
	public static void main(String[] args) {
		
		User user = new User.Builder().setId(1L).build();
		
		User user2 = new User.Builder().setId(1L).setEmail("alan@alan").build();
		
		User user3 = new User.Builder().setId(1L).setEmail("alan@alan").setFirstName("alan").build();
		
		User user4 = new User.Builder().setEmail("alan@alan").setFirstName("alan").setLastName("sastre").build();
		
		// user4 = userDAO.create(user4);
		
		
		
		
	}

}
