package com.example.springpatterns.patterns.behavioral.observer;

/**
 * Interface que Representa un Observador puede ser cualquier cosa un Computer, SmartPhone, SmartWatch, etc, que implementen esta interfaz y proporcione el metodo update
 */
public interface WeatherObserver {
    /**
     * Actualiza el estado del observador con la nueva informacion notificada sobre la clase que cambia
     * tengo una clase que cambia y este es quien se actualiza
     * @param type
     */
    void update(WeatherType type);
}
