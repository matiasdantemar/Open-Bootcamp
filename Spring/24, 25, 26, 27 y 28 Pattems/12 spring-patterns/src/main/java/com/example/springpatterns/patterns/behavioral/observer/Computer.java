package com.example.springpatterns.patterns.behavioral.observer;

//para Computer
//Observadores concretos
public class Computer implements WeatherObserver{
    // solo tiene un metodo update que lo unico que hace es imprimirlo, como que le a llegado un mensaje una notificacion
    @Override
    public void update(WeatherType type) {
        System.out.println("Computer has been notified of weather change: " + type);
    }
}
