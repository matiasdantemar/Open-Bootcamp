package com.example.springpatterns.patterns.creational.factory;

public class EmpleadoFactory {
	
	/**
	 * Devuelve un empleado del tipo solicitado
	 * @return
	 */
	public Empleado getEmpleado(EmpleadoType type){ //puede devolver un objeto de tipo empleado y que ese empleado sea de un tipo u otro, una de las clase hija, vamos a tratar a
//todas por igual, sea mecanico o programador, que sean clases de objetos diferentes lo tratamos como si fueran objetos de la clase empleado
		
		// opcion 1 
//		if (type == "MECANICO") {
//			return new Mecanico();
//		} else if(type == "PROGRAMADOR"){
//			return new Programador();
//		}else{
//			throw new IllegalArgumentException("Tipo empleado no existe " + type);
//		}
		
//		 opcion 2
//		switch (type) {
//		case "MECANICO":
//			return new Mecanico();
//		case "PROGRAMADOR":
//			return new Programador();
//
//		default:
//			throw new IllegalArgumentException("Tipo empleado no existe " + type);
//		}

		// Retorna un objeto Mecanico o Programador
		// opcion 3
		switch (type) {
		case MECANICO:
			return new Mecanico();
			// ejemplo de como conectar con la fachada
			// return SmartPhoneFacade.startSmartPhone();
		case PROGRAMADOR:
			
			return new Programador();

		default:
			throw new IllegalArgumentException("Tipo empleado no existe " + type);
		}
		
	}

}
