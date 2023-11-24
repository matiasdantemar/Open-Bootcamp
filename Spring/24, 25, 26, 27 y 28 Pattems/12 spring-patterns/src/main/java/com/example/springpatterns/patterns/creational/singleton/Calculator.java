package com.example.springpatterns.patterns.creational.singleton;

/**
 * Clase que implementa el patrón singleton
 * sirve cuando quiero crear un objeto que sirva para toda la aplicacion, como ocurre con los servicios
 * cuando inyectamos un @Bean de tipo service o repository, spring crea ese objeto inyectandolo en varios sitios de la aplicacion, usando el patron singleton por cuestion de eficiencia
 * un objeto que voy a usar en varios sitios necesito que siempre sea el mismo objeto para todas las partes de la aplicacion, evitando tener que instanciarlo a cada momento
 */
public class Calculator {

	private static Calculator calculadora;
	
	private Calculator() {
		
	}
	
	public static Calculator getCalculator(){

		if(calculadora == null) //la proxima vez que pase por el condicional no creara el objeto porque ya existe
			calculadora = new Calculator(); //solo se crea un objeto de esta clase
		
		return calculadora;
	}
	
	
	
	
	public int sum(int num1, int num2) {
		return num1 + num2;
	}
}
