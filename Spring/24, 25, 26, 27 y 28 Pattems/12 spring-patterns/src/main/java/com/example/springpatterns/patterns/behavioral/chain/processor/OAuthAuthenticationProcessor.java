package com.example.springpatterns.patterns.behavioral.chain.processor;

import com.example.springpatterns.patterns.behavioral.chain.AuthenticationProcessor;
import com.example.springpatterns.patterns.behavioral.chain.AuthenticationProvider;
import com.example.springpatterns.patterns.behavioral.chain.provider.OAuthProvider;

//es la clase de JWT
public class OAuthAuthenticationProcessor extends AuthenticationProcessor {


    public OAuthAuthenticationProcessor(AuthenticationProcessor next) {
        super(next);
    }

    @Override
    public boolean isAuthorized(AuthenticationProvider provider) {

        // comprobaciones particulares de este processor (manejador o filtro)
        if(provider instanceof OAuthProvider){ //si es una instancia de OAuthProvider
            return true;
        }

        // llama al siguiente processor (manejador o filtro)
        return next.isAuthorized(provider);
    }
}
