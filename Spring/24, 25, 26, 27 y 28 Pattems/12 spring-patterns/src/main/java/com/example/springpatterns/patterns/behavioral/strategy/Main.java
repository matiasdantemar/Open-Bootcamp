package com.example.springpatterns.patterns.behavioral.strategy;

public class Main {

	
	public static void main(String[] args) {
        // se crea un ShopCart, Preparar los datos
        ShopCart cart = new ShopCart();

        // se crean dos productos
        Product product1 = new Product("1422342342DSFDSF", 9.99);
        Product product2 = new Product("1422342342DSFDSF", 99.99);

        // se añaden los productos
        cart.addProduct(product1);
        cart.addProduct(product2);

        // Crear y ejecutar estrategia (metodo de pago): PayPal
        cart.pay(new PayPalStrategy("","","")); // los parametros no lo lleno por que son datos ficticios

        // Crear y ejecutar estrategia (metodo de pago): Tarjeta de Credito
        cart.pay(new CreditCardStrategy("","","", ""));

        // Si la interfaz tiene un solo metodo es una interfaz funcional y se pueden utilizar lambdas, ahorrando tener que crear implementaciones strategy
        // estamos pasandole una lambda, porque el metodo pay recibe un objeto de tipo PaymentStrategy la que es una interfaz funcional
        // aun asi tambien es recomendable tener separado en clases para tener implementaciones separadas
        cart.pay(
                (amount) -> System.out.println(amount)); //lambda



        // La ventaja es que puedo seguir agregando nuevas estrategias, nuevos metodos de pago AmazonPay, mercadopago, etc.

        // Patron strategy cuando necesito cambiar un algoritmo por otro de forma dinamica
	}
}
