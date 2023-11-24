package com.example.springpatterns.patterns.creational.factory;

// este patron se usa cuando crear un objeto es complicado y no queremos hacerlo desde aqui, llamamos a una clase que se llama EmpleadoFactory que se encarga a traves de una
// estructura de control, incluso con polimorfismo, herencia, se le indica al factory el tipo de objeto que se desea
// Empleado es clase padre, Mecanico y Programador hijos
public class Main {
	
	public static void main(String[] args) {
		// Las enum tienen un nombre y un valor ordinal numérico empezando en 0
		EmpleadoType[] types = EmpleadoType.values();
		
		EmpleadoFactory factory = new EmpleadoFactory();
		
		// MONTAR EQUIPO
		Empleado prog1 = factory.getEmpleado(EmpleadoType.PROGRAMADOR);
		// se puede combinar también con el patrón prototype a mayores
		// prog1.copy();
		
		
		Empleado prog2 = factory.getEmpleado(EmpleadoType.PROGRAMADOR);
		Empleado prog3 = factory.getEmpleado(EmpleadoType.PROGRAMADOR);
		
		Empleado mecanico1 = factory.getEmpleado(EmpleadoType.MECANICO);
		Empleado mecanico2 = factory.getEmpleado(EmpleadoType.MECANICO);
		
		
		
	}

}
