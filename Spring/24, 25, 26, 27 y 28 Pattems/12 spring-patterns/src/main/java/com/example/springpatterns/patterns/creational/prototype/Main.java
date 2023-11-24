package com.example.springpatterns.patterns.creational.prototype;


// Esta orientado a copiar un objeto, tengo un objeto prototipo y a partir de alli voy creando copias
// Ejemplo el objeto HttpSecurity en la clase WebSecurityConfig, el cual lleva bastante trabajo configurarlo porque se le pueden agregar muchas opciones, nos interesa tener diferentes
// configuraciones de seguridad, que valga para JWT otra para sesiones de Http normales con sesion, otro para OAUTH, pero todas tendran algo en comun, que todas tienen las rutas, sesion
// de peticiones, etc, se podria crear un prototype de la seguridad base y cada vez que quiero crear una nueva seguridad nos hacemos una copia y en esa copia añado lo que necesite
public class Main {
	
	public static void main(String[] args) {
		
		Circle circle = new Circle("azul", 10);
		
		Shape circle2 = circle.copy();
		circle2.setColor("rojo");
		
		Circle circle3 = (Circle) circle.copy();
		System.out.println(circle3);
	}

}
