package com.example.springpatterns.patterns.behavioral.chain.processor;

import com.example.springpatterns.patterns.behavioral.chain.AuthenticationProcessor;
import com.example.springpatterns.patterns.behavioral.chain.AuthenticationProvider;
import com.example.springpatterns.patterns.behavioral.chain.provider.JWTAuthProvider;

public class    JWTAuthenticationProcessor extends AuthenticationProcessor {
    public JWTAuthenticationProcessor(AuthenticationProcessor next) {
        super(next);
    }

    @Override
    public boolean isAuthorized(AuthenticationProvider provider) {

        // comprobaciones particulares de este processor (manejador o filtro)
        if(provider instanceof JWTAuthProvider) //si es una instancia de JWTAuthProvider
            return true;

        // llama al siguiente processor (manejador o filtro)
        return next.isAuthorized(provider);
    }
}
