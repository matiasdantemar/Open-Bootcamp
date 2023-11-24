package com.example.springpatterns.patterns.structural.facade;

// voy a encontrar un metodo especial que crea SmartPhone con todo lo que conlleva, una bateria, CPU, arranca los sensores de ubicacion, acelerometro, si vamos al package pieces
// estaran todas las piezas que estoy creando

import com.example.springpatterns.patterns.structural.facade.pieces.*;

import java.util.Arrays;
import java.util.List;

public class SmartPhoneFacade {

	
	public static SmartPhone startSmartPhone() {

		// estoy creando todas las piezas
		// ensamblar el smartphone y encenderlo
		Battery battery = new Battery();
		
		CPU cpu = new CPU();
		
		Screen screen = new Screen();
		
		Sensor gps = new GPSSensor();

		Sensor nfc = new NFCSensor();
		List<Sensor> sensors = Arrays.asList(gps, nfc);
		
		SmartPhone oneplus = new SmartPhone(battery, cpu, screen, sensors);
		
		
		oneplus.start();
		
		for (Sensor sensor : oneplus.getSensors()) {
			sensor.start();
		}
		
//		oneplus.checkSIM();
//		oneplus.start();
//		oneplus.checkConnectivity();
		return oneplus;
		
	}
	
	
	
}
