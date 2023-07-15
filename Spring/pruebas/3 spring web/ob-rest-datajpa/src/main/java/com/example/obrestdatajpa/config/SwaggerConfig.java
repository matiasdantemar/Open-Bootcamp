package com.example.obrestdatajpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket; //implementa el patron builder


import java.util.Collections;

//agregar un bean

/**
 *  Configuracion Swagger para la generacion de documentacion de la API REST
 *  HTML: http://localhost:8080/swagger-ui/
 *  JSON: http://localhost:8080/v2/api-docs
 */
@Configuration
public class SwaggerConfig {

    @Bean //va a ser un Bean que va a estar disponible en el contenedor de Beans, spring ejecuta el metodo
    //patron builder, puedo ir concatenando llamadas hacer Method Chaining, llamo a un metodo y me devuelve el mismo objeto para poder llamar a otro metodo
    public Docket api(){ //metodo que crea un bean, spring llama a este metodo, genera el objeto Docket lo guarda en el contenedor de beans y este disponible para quien lo pida
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetails())//tendra la descripcion de la API, nombre empresa, version, terminos de uso, licencia, enlace a documentacion, contactanos, etc
                .select()// para acceder a las opciones de selección de rutas.
                .apis(RequestHandlerSelectors.any())// para seleccionar todas las rutas y generar documentación para todas ellas.
                .paths(PathSelectors.any()) //para incluir todas las rutas en la documentación
                .build();
    }//Spring ya tendria listo este objeto, las clases de la libreria detectan este objeto disponible y seran inyectadas donde corresponda (clases de swagger)


    private ApiInfo apiDetails(){
        return new ApiInfo("Spring Boot Book API REST",
                "Library Api rest docs",
                "1.0",
                "http://www.google.com",
                new Contact("Maatias", "http://www.google.com" , "matias@hotmail.com"),
                "MIT",
                "http://wwww.google.com",
                Collections.emptyList());
    }
}
