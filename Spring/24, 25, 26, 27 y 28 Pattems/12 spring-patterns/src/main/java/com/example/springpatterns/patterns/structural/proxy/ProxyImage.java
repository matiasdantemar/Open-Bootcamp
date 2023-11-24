package com.example.springpatterns.patterns.structural.proxy;


//el proxy lo que hace es ser intemediario y hacerse pasar por la imagen real, o conexion a BD, etc
public class ProxyImage implements Image {

    private RealImage realImage; //va a tener un objeto que va a ser el  RealImage, quien vaya a hacer uso de ello va a interactuar con el proxy y el proxy va a llamar a RealImage
    private String fileName; //lo necesito porque cuando alguien cree el ProxyImage le enviara fileName

    public ProxyImage(String fileName) { //este constructor solo sera con fileName por que la idea es que el ProxyImage sea el encargado de crear el RealImage
        this.fileName = fileName;
    }

    @Override
    public void show() {
//este proceso podria tener mas cosas como preparar el entorno, borrar una carpeta y volver a generarlo, comprobacion de una API que no tengamos un limite de peticiones ya gastado
        // El objeto realImage se crea una sola vez
        if (realImage == null){
            this.realImage = new RealImage(fileName); // aqui se inicializa solo si el objeto se usa, diferimos la carga de un objeto pesado, la proxima vez que haga show no sera nulo
        }
        realImage.show(); //muestra imagen
    }
}
