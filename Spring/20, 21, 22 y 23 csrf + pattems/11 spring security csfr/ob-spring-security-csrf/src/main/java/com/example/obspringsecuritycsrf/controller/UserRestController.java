package com.example.obspringsecuritycsrf.controller;

import com.example.obspringsecuritycsrf.dto.UserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {


    @GetMapping("/hola")
    public String hola(){
        return "hola mundo";
    }

    @PostMapping("/users")
    public String save(@RequestBody UserDTO user){ //@RequestBody anotacion que sirve para indicar a spring que extraiga los datos del cuerpo de la peticion POST y la cargue en user
        System.out.println(user); //verifico que los datos me esten llegando
        return "OK";
    }
}
