package com.example.obspringsecurityoauthgithub.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // va aser un controlador MVC modelo vista controlador, no va a retornar JSON si no una plantilla HTML, mostrar una interfaz de usuario.
public class HelloController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/page1")
    public String page1(Model model){ // para mostrar mensaje java se utiliza la clase Model
        model.addAttribute("message", "Hola mundo desde MVC");
        return "page1";
    }

    @GetMapping("/page2")
    public String page2(Model model,
                        @RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient client,
                        @AuthenticationPrincipal OAuth2User user //porporciona el nombre, los atributos
    ){
        model.addAttribute("clientName", client.getClientRegistration().getClientName());
        model.addAttribute("userName", user.getName());
        model.addAttribute("userAttributes", user.getAttributes());
        return "page2";
    }
}
