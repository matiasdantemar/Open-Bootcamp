package com.example.springpatterns.patterns.creational.factory;

import java.util.ArrayList;
import java.util.List;

// es importante que extiendan de una clase generica, una clase padre, tanto Mecanico como Programador
public class Programador extends Empleado {

	List<String> languages = new ArrayList<>();
}
