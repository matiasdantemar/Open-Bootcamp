package com.example.obrestdatajpa.controller;

import com.example.obrestdatajpa.entities.Book;
import com.example.obrestdatajpa.repository.BookRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    /*el repository se puede añadir a traves de un atributo, constructor o setter, lo recomendable es
    un constructor asi facilita el tester, tengo que inyectar la dependencia repository en esta clase*/
    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    //CRUD sobre la entidad book

    //Read: buscar todos los libros (lista de libros)
    @GetMapping("/api/books")
    public List<Book> findAll(){
        // recuperar y devolver los libros de base de datos
        return bookRepository.findAll();
    }


    //Read: buscar un solo libro segun su id en case de datos
    @GetMapping("/api/books/{id}" )
    //ResponseEntity es un tipo de dato especial de spring para devolver respuestas HTTP, devuelve un objeto en JSON
    public ResponseEntity<Book> findOneById(@PathVariable Long id){
        Optional<Book> bookOpt = bookRepository.findById(id); //si no exixste el id igual recibe un Optional
        //opcion 1 con ResponseEntity
//        if(bookOpt.isPresent())
//            return ResponseEntity.ok(bookOpt.get());
//        else
//            return  ResponseEntity.notFound().build(); // .notFound 404, .build significa que construya la cabecera
        //opcion 2
        return bookOpt.map(ResponseEntity::ok) // 1. método map() de Optional para transformar el valor presente en un ResponseEntity.ok()
                .orElseGet(() -> ResponseEntity.notFound().build()); //método orElseGet() para obtener un ResponseEntity.notFound() si el Optional está vacío
    }


    //Create: crear un nuevo libro en base de datos
    @PostMapping("/api/books")
    //RequestBody Request es peticion el Body es el cuerpo de la peticion, trae la informacion de la peticion y cargala en un parametro de tipo Book
    public Book create(@RequestBody Book book, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent")); //el User-Agent nos dice quien esta enviando la peticion si firefox con windows, o con linux, postman. python etc
        return bookRepository.save(book);
    }


    //Update: actualizar un libro existente en base de datos



    //Delete: borrar un libro en base de datos

}
