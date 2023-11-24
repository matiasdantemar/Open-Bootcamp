package com.example.springpatterns.patterns.structural.proxy;

public class RealImage implements Image{

    private String fileName;


    public RealImage(String fileName ){ //el constructor va a permitir que lo que se ejecute en el main se va a entender mejor
        this.fileName = fileName;
        loadFromDisk(fileName); //llamada a un metodo
    }

    private void loadFromDisk(String fileName) { //las carga de imagenes en la web es algo que suele tardar, en instagram te reconoce el entorno, ejemplo hay dos personas
        System.out.println("Loading image " + fileName);
    }

    @Override
    public void show(){
        System.out.println("Showing "+ fileName); //muestra el nombre del archivo
    }

    //metodo cargar desde el disco
}
