package com.example.springpatterns.patterns.behavioral.strategy;
// Clase carrito de compra, tiene metodo agregar y remover productos, ademas pay pagar
import java.util.ArrayList;
import java.util.List;

public class ShopCart {


    // array List de productos
    private List<Product> products;

    public ShopCart() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product){
        this.products.add(product);
    }

    public void removeProduct(Product product){
        this.products.remove(product);
    }

    // pagar utilizando una estrategia de pago, recibe en los parametros un PaymentStrategy, de lo que haya seleccionado el usuario tendra paypal o trajeta de credito
    public void pay(PaymentStrategy paymentMethod){
        // opcion 1: itera de forma funcional:
    	Double result = products.stream()
                .map(Product::getPrice)
                .reduce(Double::sum)
                .orElse(0d);
        
        // opcion 2: itera de forma imperativa
        double amount = 0;
        for (Product product : products) {
            amount += product.getPrice();
        }

        // llama al metodo pagar, habiendo calculado previamente el precio total de los productos
        paymentMethod.pay(amount);
    }

}
