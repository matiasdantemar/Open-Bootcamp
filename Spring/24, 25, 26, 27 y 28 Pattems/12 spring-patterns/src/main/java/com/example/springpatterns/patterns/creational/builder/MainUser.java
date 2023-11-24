package com.example.springpatterns.patterns.creational.builder;

// para un solo valor no compensa, es mas complicado tengo que usar mas codigo, para construir objetos de un solo atributo no tiene sentido utilizar un patron Builder ni de 2 o 3
// compensa cuando tenemos objetos como http Security que tenemos muchisimas cosas para configurar y cada vez configurare una diferente
public class MainUser {
    public static void main(String[] args){
        //clase User y si hago "." puedo usar la clase Builder() le hago "." y puedo usar los sett
        User user1 = new User.Builder().setId(1L).build(); // seria crear un objeto con un solo valor

        User user2 = new User.Builder().setId(1L).setFirstName("Matias").build(); // objeto con dos atributos

        User user3 = new User.Builder().setId(1L).setFirstName("Matias").setLastName("Martinez").build(); // objeto con tres atributos

        // esta es otra manera
        User user4 = new User.Builder()
                .setId(1L).setFirstName("Matias").setLastName("Martinez")
                .setEmail("matias@hotmail.com")
                .build(); // objeto con tres atributos

        // esta es la manera mas tipica
        User.Builder builder = new User.Builder();
        builder.setId(1L);
        builder.setFirstName("Matias");
        builder.setLastName("Martinez");
        builder.setEmail("matiasdante@hotmail.com");
        builder.setMarried(false);
        User user5 = builder.build();  // objeto con cuatro atributos

        // el orden de los set pueden ser los que quiera

    }
}
