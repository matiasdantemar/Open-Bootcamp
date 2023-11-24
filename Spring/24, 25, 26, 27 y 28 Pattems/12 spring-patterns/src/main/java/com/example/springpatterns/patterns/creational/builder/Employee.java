package com.example.springpatterns.patterns.creational.builder;

// IntelliJ te permite generar los metodos setter que devuelvan el objeto con return this, generate -> getter and setter -> setter template [Builder]
public class Employee {
    
    private Long id;
    private String name;

    public static class Builder{
        //atributos
        private Long id;
        private String name;

        //constructor
        public Builder(Long id, String name) {
            this.id = id;
            this.name = name;
        }


        public Long getId() {
            return id;
        }

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public String getName() {
            return name;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }
    }

}
