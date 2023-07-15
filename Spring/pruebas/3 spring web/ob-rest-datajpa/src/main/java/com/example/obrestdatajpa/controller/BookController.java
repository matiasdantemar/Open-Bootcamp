package com.example.obrestdatajpa.controller;

import com.example.obrestdatajpa.entities.Book;
import com.example.obrestdatajpa.repository.BookRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    //LoggerFactory es un patron de diseño
    private final Logger log = LoggerFactory.getLogger(BookController.class); //permite mostrar errores con colores, niveles de error, hora etc


    /*el repository se puede añadir a traves de un atributo, constructor o setter, lo recomendable es
    un constructor asi facilita el tester, tengo que inyectar la dependencia repository en esta clase*/
    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    /**
     * Buscar todos los libros que hay en base de datos(ArrayList de libros)
     * http://localhost:8080/api/books
     * @return
     */
    @GetMapping("/api/books")
    public List<Book> findAll(){
        // recuperar y devolver los libros de base de datos
        return bookRepository.findAll();
    }


    /**
     * http://localhost:8080/api/books/1
     * Request
     * Response
     * @param id
     * @return
     */
    // buscar un solo libro segun su id en case de datos
    @GetMapping("/api/books/{id}" )
    //ResponseEntity es un tipo de dato especial de spring para devolver respuestas HTTP, devuelve un objeto en JSON
    @ApiOperation("Buscar un libro por clave primaria id Long")
    public ResponseEntity<Book> findOneById(@ApiParam("clave primaria tipo Long") @PathVariable Long id){
        Optional<Book> bookOpt = bookRepository.findById(id); //si no exixste el id igual recibe un Optional, sirve para no trabajar con null
        //opcion 1
//        if(bookOpt.isPresent())
//            return ResponseEntity.ok(bookOpt.get());
//        else
//            return  ResponseEntity.notFound().build(); // .notFound 404, .build significa que construya la cabecera
        //opcion 2
        return bookOpt.map(ResponseEntity::ok) // 1. método map() de Optional para transformar el valor presente en un ResponseEntity.ok()
                .orElseGet(() -> ResponseEntity.notFound().build()); //método orElseGet() para obtener un ResponseEntity.notFound() si el Optional está vacío
    }


    /**
     * Crea un nuevo libro en base de datos
     * Metodo Post, no colisiona con el metodo findAll() por que son diferentes metodos HTTP: Get y Post
     * @param book
     * @param headers
     * @return
     */
    @PostMapping("/api/books")
    //RequestBody "Request" peticion "Body" cuerpo de la peticion, trae la informacion de la peticion y cargala en un parametro de tipo Book
    public ResponseEntity<Book> create(@RequestBody Book book, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent")); //el User-Agent nos dice quien esta enviando la peticion si firefox con windows, o con linux, postman. python etc
        if (book.getId() != null) {// existe el id y por lo tanto no es una creacion
            /*cuando se produce un error podemos imprimirlo en los logs, implementar framework de logging que guarda esos datos en un archivo que se lee
            constantemente y se envia a un sistema como Elastic Stack, se guarda en un BD y luego se muestra con un dashboard y se puede ver errores en tiempo real*/
            log.warn("tryind to create a book with id");
            return ResponseEntity.badRequest().build();
        }
        Book result = bookRepository.save(book);
        return ResponseEntity.ok(result);
    }


    /**
     * actualizar un libro existente en base de datos
     */
    @PutMapping("/api/books")
    public ResponseEntity<Book> update(@RequestBody Book book){
        if (book.getId() == null) {// si no tiene id es una creacion
            log.warn("Tryind to update a non existent book");
            return ResponseEntity.badRequest().build();
        }
        if (!bookRepository.existsById(book.getId())){// si no existe el id
            log.warn("Tryind to update a non existent book");
            return ResponseEntity.notFound().build();
        }
        Book result = bookRepository.save(book);
        return ResponseEntity.ok(result);
    }


    //Delete: borrar un libro en base de datos
    @ApiIgnore
    @DeleteMapping("/api/books/{id}")
    public ResponseEntity<Book> delete(@PathVariable Long id){
        if (!bookRepository.existsById(id)){// si no existe el id
            log.warn("Tryind to delete a non existent book");
            return ResponseEntity.notFound().build();
        }

        bookRepository.deleteById(id);
        return  ResponseEntity.noContent().build(); //noContent quiere decir que se ha borrado correctamente
    }

    @ApiIgnore  
    @DeleteMapping("/api/books")
    public ResponseEntity<Book> deleteAll() {
        log.info("REST Request for delete all books");
        bookRepository.deleteAll();
        return ResponseEntity.noContent().build(); //noContent quiere decir que se ha borrado correctamente
    }

}
