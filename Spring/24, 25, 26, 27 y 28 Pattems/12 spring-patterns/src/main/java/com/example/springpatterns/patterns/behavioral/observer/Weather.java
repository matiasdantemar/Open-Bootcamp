package com.example.springpatterns.patterns.behavioral.observer;

// representa el tiempo climatologico, si es lluvioso, nubloso, soleado, tormentas, nieve
import java.util.ArrayList;
import java.util.List;

/**
 * Clase Weather que notifica del cambio de tiempo a los observadores, observadores que tenga aqui declarados
 * tendria un tiempo (One (Weather) - To - Many (Observers)) y muchos observadores
 */
public class Weather { //One
 
    private WeatherType currentWeather; // WeatherType es una enumeracion del tiempo, como agrupacion de constantes, tiene RAINY(lluvioso), CLOUDY(nublado), SUNNY(soleado)
    // Many
    private List<WeatherObserver> observers; //WeatherObserver tiene una lista de observadores, esta es una interface para desaclopar codigo, implementaciones que implementen esa
    //interfaz entonces los observadores podrian ser cualquier tipo que implementen esa interfaz, alli se logra desacoplar codigo por un tipo abstracto

    public Weather(){
        this.observers = new ArrayList<>();
    }

    //añade un nuevo observador
    public void addObserver(WeatherObserver obs){
        System.out.println("Added observer");
        this.observers.add(obs);
    }

    //borrar observador
    public void removeObserver(WeatherObserver obs){
        System.out.println("Removed observer");
        this.observers.remove(obs);
    }

    /**
     * Metodo clave, realiza la magia
     * cambia el tiempo y notifica a los observadores asociados
     * Tengo algo que cambia, cuando cambia notifica al resto de objetos que esten asociados o subscriptos
     * @param currentWeather
     */
    void changeWeather(WeatherType currentWeather){
        this.currentWeather = currentWeather; // cambia el tiempo
        this.notifyObservers(); // notifica
    }

    /**
     * Notifica el cambio de tiempo a los objservadores
     */
    private void notifyObservers(){
        //Implementa polimorfismo, se tratan los observadores como objetos WeatherObserver
        for (WeatherObserver observer: this.observers) { //itera sobre los observer con un bucle for, estos observers son de tipo abstractos, podrian ser de cualquier tipo siempre
            //y cuando implementen la interfaz WeatherObserver
            observer.update(this.currentWeather); //el metodo update esta en WeatherObserver, estoy haciendo un update con el currentWeather con el nuevo tiempo, esta avisando que
            //se a producido el cambio de el en el Weather
        }
    }

    //el metodo notifyObservers se podria hacer en el metodo changeWeather, pero separo los dos metodos para que se entienda mejor
}
