package com.example.obspringsecuritycsrf.controller;

import com.example.obspringsecuritycsrf.dto.UserDTO;
import org.springframework.web.bind.annotation.*;

//Controller para cuando uso token, sesiones, para intercambio de datos entre diferentes aplicaciones o una aplicacion javascript con mi aplicacion backend
@RestController
public class UserRestController {

    //Cuando tenemos controlador Rest y Mvc es obligatorio usar /api/

    //URLS Permitidas
    @GetMapping("/api/hola")
    public String hola(){
        return "hola mundo";
    }

    //URLS Autenticadas
    @GetMapping("/api/adios")
    public String adios(){
        return "adios mundo";
    }

    @PostMapping("/api/users")
    public String save(@RequestBody UserDTO user){ //@RequestBody anotacion que sirve para indicar a spring que extraiga los datos del cuerpo de la peticion POST y la cargue en user
        System.out.println(user); //verifico que los datos me esten llegando
        return "OK";
    }
}
