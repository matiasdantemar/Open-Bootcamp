package com.example.springpatterns.patterns.behavioral.template;

// Template (Method) es una especie de plantilla comun para comportamientos que queremos que sean muy parecidos, en este caso mostrar render renderizar un HTML
// Cuando tengo que realizar un proceso que tiene ciertas partes que son repetititvas, esas partes se pueden crear como plantilla y centrarme en aquellas partes que son especificas

// se crea un metodo principal que tiene partes comunes y que dentro tiene una llamada a un metdoo abstracto que va ser el que vamos a implmentar desde clases fijas, para proporcionar
// aquel codigo que sea especifico

// Ejemplo metodo add() addll() de Listas de java
// Ejemplo en las clases de spring terminadas en Template JdbcTemplate, del acceso a BD (siguiente ejemplo) que permite por una serie de metodos ejemplo execute() ejecuta una
// operacion sin preocuparme por la conexion, simplificando el proceso, spring implementa el metodo, yo solo llamo al metodo y ejecuto el comportamiento
// Ejemplo cuando accedo a BD y existen una serie de pasos comunes, crear conexion, ejecutar una sentencia, procesar un resultado, cerrar conexion, es algo repetitivo e implementarlo
// a cada rato no tiene sentido, entonces se crea una plantilla con los cuatro pasos y tener tres y dejar uno que se implemente solo por el usuario

public class Main {

    public static void main(String[] args) {

        HtmlHome home = new HtmlHome(); //Creo una nueva instancia de la clase HmlHome
        System.out.println(home.render()); //ejecuto el metodo render que se encarga de generar la estructura
// el metodo render() es el metodo plantilla, renderiza teniendo en cuenta las partes que son comunes junto con las partes especificas que estan en las clases hijas

        HtmlAboutUs about = new HtmlAboutUs(); //Creo una nueva instancia de la clase HtmlAboutUs
        System.out.println(about.render());
    }

}
