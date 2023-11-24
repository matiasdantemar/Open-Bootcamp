package com.example.springpatterns.patterns.behavioral.chain;

// para la autenticacion
public abstract class AuthenticationProcessor {

    //sera el siguiente Manejador
    public AuthenticationProcessor next;

    //constructor para poder utilizar next
    public AuthenticationProcessor(AuthenticationProcessor next) {
        this.next = next;
    }

    //Comprueba si esta autorizado o no, parametro clase AuthenticationProvider
    public abstract boolean isAuthorized(AuthenticationProvider provider);
}
