package com.example.obspringsecuritycsrf.controller;

import com.example.obspringsecuritycsrf.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

//Controlador para redirigir a una plantilla HTML y generar el frontend desde el backend
@Controller
public class UserMvcController {

    // 1er paso: obtener un formulario en el Frontend (HTML)
    @GetMapping("/") //redirigimos a user-form.html
    public String getForm(Model model){ //Model esta relacionado con la creacion de interfaz de usuarios
        model.addAttribute("user", new UserDTO());
        return "user-form"; //voy a redirigir hacia una pantalla que se va a llamar user-form
    }


    // 2d paso: Recibir el formulario con los datos rellenos
    @PostMapping("/users")
    //para recibir objetos en MVC, en Rest usamos @RequestBody. aqui usamos @ModelAttribute
    public String save(@ModelAttribute("user") UserDTO user){ //@ModelAttribute va a extraer datos de un formulario html y los va a cargar en user
        System.out.println(user);
        return "congratulations";
    }
    //para rellenar el formulario
}
