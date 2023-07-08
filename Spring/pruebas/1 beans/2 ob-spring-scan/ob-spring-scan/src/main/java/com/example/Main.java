package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
     public static void main(String[] args){
         // CONCEPTO 1 Comó obtener beans de Spring

         // Opción 1. Crear un objeto de forma normal
         //Calculadora service = new Calculadora();

         /*esto sirve cuando estamos creando una aplicacion mucho mas grande
           la cual tenemos muchas clases y queremos acceder a un mismo objeto desde muchas clases
           en vez de estar creando muchas veces un objeto lo creamos en el contenedor de beans
           lo inyectamos o lo obtenemos asi y ya no tendrimaos que hacer la creacio nosotros,
           ese mismo objeto se inyecta en todos los sitios entonces mejoramos el uso de memoria
           porque no estamos creando nuevos objetos a cada rato*/

         // Opción 2. Recibir un objeto de Spring
         ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
         /*la idea de este objeto es que lo podriamos reutilizar, si yo necesito este objeto desde varias clases
         solo lo creamos una vez y esta disponible en el contenedor de beans de spring,
         con crearlo una vez es suficiente, se inyecta, el resto de clases que lo necesiten lo piden
         dicen dame el objeto calculadora y spring se lo da, la ventaja de no haberlo creado,
         no lo creo en cualquier clase si no que es spring quien me lo da
         YO NO HE CREADO UN NUEVO OBJETO CON NEW este lo crea spring*/
         Calculadora calculadora = (Calculadora) context.getBean("calculadora");

         String texto = calculadora.holaMundo();
         System.out.println(texto);

         /*se crea el objeto una vez, auqnue obtengo 2 veces el bean a "calculadoraService",
         pero solo se ha construido una vez, porque solo pasa una vez por el metodo constructor
         se puede volver a obtener, se recupera el mismo objeto*/
         Calculadora calculadora2 = (Calculadora) context.getBean("calculadora");

         texto = calculadora2.holaMundo();
         System.out.println(texto);

         // CONCEPTO 2 Cargar un bean dentro de otro bean
         GestorFacturas gestor = (GestorFacturas) context.getBean("gestorFacturas");
         System.out.println(gestor.calculadora.holaMundo());

         /* CONCEPTO 3: Scope o alcance
         los beans por defecto son singleton, se crea el objeto y se reutiliza para toda la aplicación
         podemos cambiarlo a scope="prototype" si queremos que se cree un nuevo objeto cada vez
         notar que se ejecuta 3 vece sel constructor de calculadora*/


     }
}
