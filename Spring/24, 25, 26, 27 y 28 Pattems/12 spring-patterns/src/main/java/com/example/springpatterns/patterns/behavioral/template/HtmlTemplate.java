package com.example.springpatterns.patterns.behavioral.template;

// tipo abstracto

// se crea un metodo principal que tiene partes comunes y que dentro tiene una llamada a un metdoo abstracto que va ser el que vamos a implmentar desde clases fijas, para proporcionar
// aquel codigo que sea especifico
public abstract class HtmlTemplate {

    //Metodo que define la plantilla, reutilizando todas las partes que son comunes de las mismas, se encarga de ordenar los tres metodos, puede ser un constructor
    // se define una estructura comun, el orden y demas, de manera que las clases hijas se encargan implementar aquellas partes que sean exclusivas para el objetivo a lograr
    public String render(){ // el metodo render es el metodo plantilla

        // return head() + body() + footer(); // Otra opcion

        return String.format("""
                %s
                %s
                %s
                """, head(), body(), footer());
    } //se reemplaza %s por head, %s por body...

    public abstract String head();
    public abstract String body();

    // El footer va a ser siempre lo mismo para todas las paginas, va a ser comun a todos las clases que vaya a implementar de aqui
    public String footer(){
        return """
                <footer>
                    Copyright 2021
                </footer> </body></html>
                """;
    };
}
