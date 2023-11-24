package com.example.springpatterns.patterns.behavioral.strategy;

// representa los pagos, interface funcional (son las que tienen un solo metodo)
// esto permite pasar una lambda a quien lo este utilizando, una lambda que proporcione el cuerpo del metodo
public interface PaymentStrategy {

    // con metodo pay Pagar
    public void pay(double amount);
}
