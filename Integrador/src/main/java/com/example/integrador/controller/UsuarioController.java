package com.example.integrador.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {


    @GetMapping("/usuario")
    public String usuario(){
        return "<h2> Bienvenido Usuario! </h2>";
    }

    @GetMapping("/admin")
    public String admin(){
        return "<h2> Bienvenido Admin! </h2>";
    }

}
