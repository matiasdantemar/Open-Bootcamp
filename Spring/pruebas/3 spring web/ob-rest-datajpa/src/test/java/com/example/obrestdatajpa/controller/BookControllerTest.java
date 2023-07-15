//A veces hay que adaptar el test, por ejemplo cuando se actualiza el código y los tests fallan.

package com.example.obrestdatajpa.controller;

import com.example.obrestdatajpa.entities.Book;
import org.apache.coyote.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
//spring se encarga de que funcione, aqui no voy a ejecutar metodos si no lanzar peticiones HTTP y recibir response entity... webEnvironment para asignar un puerto
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookControllerTest {

    private TestRestTemplate testRestTemplate; //sirve para test de integracion, puede utilizar autenticacion de cabecera, sirve para lanzar las peticiones HTTP
    @Autowired //le decimos a spring que nos inyecte este builder
    private RestTemplateBuilder restTemplateBuilder;//objeto que permite construir el TestRestTemplate indicandole la URL
    @LocalServerPort //la inyecta el propio spring, generar un puerto y lo inyectara aqui, inyecta el puerto HTTP
    private int port;

    //el setUp Method se ejecuta antes de cada metodo, este se repite varias veces
    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    @Test
    void hello() {
        //el tipo de datos le agregamos .class, va a saber que tiene que obtener como resultado un String
        ResponseEntity<String> response = testRestTemplate.getForEntity("/hola", String.class); //getForEntity lanza una peticion HTTP a la URL http://.../hola,
        // esto devuelve una respuesta HTTP que envuelve en el cuerpo de esa respuesta un <String>

        //compruebo con assertEquial si dos valores son iguales, caso contrario se generará una excepción o un error, lo que indica que la prueba ha fallado
        assertEquals(HttpStatus.OK, response.getStatusCode()); //son lo mismos
        assertEquals(200, response.getStatusCodeValue()); //son lo mismos

        assertEquals("Hola Mundo a aa!", response.getBody()); //si estraigo el Body lo que hay dentro es texto
    }

    @Test
    void findAll() {
        ResponseEntity<Book[]> response = testRestTemplate.getForEntity("/api/books", Book[].class); //le pasamos una array de lista para trabajar mas comodo
        assertEquals(HttpStatus.OK, response.getStatusCode()); //son lo mismos


        List<Book> books = Arrays.asList(response.getBody()); //asList es para convertir de array normal a array lista
        System.out.println(books.size());
    }


    @Test
    void findOneById() {
        ResponseEntity<Book> response = testRestTemplate.getForEntity("/api/books/1", Book.class);
        //se puede crear varios casos de test 1 para un libro que si existe, 2 libro que no existe, 3 que sucede si le paso un id negativo, todos los posibles escenarios
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

    }

    //un poco mas complejo por que tengo que crear un JSON y enviarselo, compuesto por json, cabeceras en la cabeceras tengo que indicar lo que envio a json
    @Test
    void create() {
        //1 creo una cabecera para indicar que voy a enviar Json
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON); //recibir JSON
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON)); //enviar Json

        //2 preparo el Json
        String json = """
                    {
                        "title": "Libro",
                        "author": "Yuval",
                        "pages": 200,
                        "price": 15.90,
                        "releaseDate": "2019-12-01",
                        "online": true 
                    }
                """;
        //3 preparo la peticionf
        HttpEntity<String> request = new HttpEntity<>(json,headers);
        //4 ejecuto la peticion...  obtengo la respuesta...      (url, tipo de metodo, el request, la clase que nos va a devolver)
        ResponseEntity<Book> response = testRestTemplate.exchange("/api/books", HttpMethod.POST, request, Book.class);

        //aqui tengo el libro que se ha generado en BD
        Book result = response.getBody();
        //comprobaciones
        assertEquals(1, result.getId());
        assertEquals("Libro", result.getTitle());
    }
}