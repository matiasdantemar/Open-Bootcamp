package com.example.springpatterns.patterns.behavioral.chain.processor;

import com.example.springpatterns.patterns.behavioral.chain.AuthenticationProcessor;
import com.example.springpatterns.patterns.behavioral.chain.AuthenticationProvider;
import com.example.springpatterns.patterns.behavioral.chain.provider.CSRFProvider;

public class CSRFAuthenticationProcessor extends AuthenticationProcessor {
    public CSRFAuthenticationProcessor(AuthenticationProcessor next) {
        super(next);
    }

    @Override
    public boolean isAuthorized(AuthenticationProvider provider) {

        // comprobaciones particulares de este processor (manejador o filtro)
        if(provider instanceof CSRFProvider) //si es una instancia de CSRFProvider
            return true;

        // llama al siguiente processor (manejador o filtro)
        return next.isAuthorized(provider);
    }
}
