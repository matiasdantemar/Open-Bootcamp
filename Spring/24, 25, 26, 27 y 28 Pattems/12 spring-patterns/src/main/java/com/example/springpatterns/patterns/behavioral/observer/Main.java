package com.example.springpatterns.patterns.behavioral.observer;

// ejemplo cuando una persona publica un tuit y tengo fijado una alerta para que me notifique, cuando una persona envia una newsletter y le llega a todos sus seguidores
// Entidad que emite un comunicado, y ese comunicado llega a todos los objetos que esten suscriptos con la ventaja de que en cualquier momento te desuscribes o te vuelves a subscribir
// De esa menera logro una comunicacion unidireccional entre el emisor y los receptores, con la flexibilidad que añado o quito un observador
public class Main {

    public static void main(String[] args) {

        // 1) Se crea la clase principal, la que cambia de estado y que los observadores quieren seguir (traquear, visualizar, tener bajo seguimiento)
        Weather aemet = new Weather();

        // 2) Se crean los observadores y se añaden a la clase principal para que puedan ser notificados cuando se produzca un cambio
        WeatherObserver computer = new Computer(); // se crea el computer
        aemet.addObserver(computer); // se añade el computer
        aemet.addObserver(new SmartPhone()); // se crea un SmartPhone, aqui se añade directamente sin sacar una variable, como "computer" se entiende mejor pero no es necesario
        //se implementa directamente c on el operador new

        // 3) Cambio del tiempo --> notifica automaticamente a los observers (en este caso computer y SmartPhone)
        aemet.changeWeather(WeatherType.CLOUDY);
        aemet.changeWeather(WeatherType.RAINY);
        aemet.changeWeather(WeatherType.SUNNY);

        // si se borra un observador y se cambia el tiempo, se vera que ya no sera notificado mas
        aemet.removeObserver(computer);
        aemet.changeWeather(WeatherType.SUNNY);
    }
}
