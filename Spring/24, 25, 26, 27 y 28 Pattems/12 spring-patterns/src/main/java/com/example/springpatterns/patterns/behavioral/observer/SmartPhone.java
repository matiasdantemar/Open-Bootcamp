package com.example.springpatterns.patterns.behavioral.observer;

//para SmartPhone
//Observadores concretos
public class SmartPhone implements WeatherObserver{
    // solo tiene un metodo update que lo unico que hace es imprimirlo, como que le a llegado un mensaje una notificacion
    @Override
    public void update(WeatherType type) {
        System.out.println("Smartphone has been notified of weather change: " + type);
    }
}
