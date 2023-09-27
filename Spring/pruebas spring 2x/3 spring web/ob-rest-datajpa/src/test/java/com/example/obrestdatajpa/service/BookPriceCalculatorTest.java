package com.example.obrestdatajpa.service;

import com.example.obrestdatajpa.entities.Book;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*; //Assertions me permite hacer aserciones, comprobaciones de si algo esta bien o mal

class BookPriceCalculatorTest {

    @DisplayName("Comprobar Hola mundo desde controlador Spring REST") //mejora la legibilidad del reporte resultados
    @Test
    void calcuulatePrice() {

        //1 configuracion de la prueba
        Book book = new Book(1L, "El señor de los anillos", "Author", 1000, 49.99, LocalDate.now(), true); //aqui estamos haciendo cobertura
        BookPriceCalculator calculator = new BookPriceCalculator();

        //2 se ejecuta el comortamiento bajo testing
        double price = calculator.calculatePrice(book);
        System.out.println(price);

        //3 comprobaciones Aserciones
        assertTrue(price > 0);
        assertEquals(57.980000000000004,price);

    }
}