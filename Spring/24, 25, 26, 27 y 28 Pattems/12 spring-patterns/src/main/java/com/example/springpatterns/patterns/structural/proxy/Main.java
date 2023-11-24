package com.example.springpatterns.patterns.structural.proxy;

//aqui el main trabajaria como el cliente, este patron es similar al patron singleton se creaba el objeto una vez y se mantenia alli, pasa un poco lo mismo solo que Proxy seria
//usar una clase intermedia que con quien interactua el cliente es con la clase ProxyImage escondiendo los detalles de lo que se hace

//yo podria crear un objeto de tipo RealImage hacer uso del mismo que cargara del disco y todo el proceso complejo, lo podria hacer y funcionaria pero lo que quiero es usar un Proxy
//que simplifique eso al cliente, el cliente solo crearia un ProxyImage le diria muestra la imagen, ya se encarga de crear el metodo show() y lo guardaria en una zona en memoria

//ejemplo: es muy comun que los frameworks creen proxys y sean quienes inicialicen las cosas, en Spring Data JPA los repository interfaces nos permite acceso a metodos para realizar
// operaciones en BD, solo creamos la interfaz no la implementacion, la implementacion me la proporciona spring


public class Main { //cliente
    public static void main(String[] args) {

        Image img = new ProxyImage("holamundo.jpg"); //creo un objeto ProxyImage, puede ser inyectado con Spring

        //El Proxy crea el objeto real por debajo la primera vez, se difiere se pospone la carga del objeto hasta que no se a inicializado o se invoque a una funcion (show())
        img.show();//se carga por primera vez la imagen, se muestra y luego permanece cargada, luego al hacer otro show

        System.out.println("===========");
        //Al hacer show de nuevo el Proxy ya tiene el objeto real creado, no lo crea de nuevo
        img.show();//simplemente se muestra, ya no tiene que volver a cargarse BD


        //patron Proxy cuando necesito diferir la carga de tal cosa, con una clase intermedia que resuelva la creacion y estructuracion de ese objeto
    }
}