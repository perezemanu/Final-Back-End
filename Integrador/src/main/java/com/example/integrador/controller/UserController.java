package com.example.integrador.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class UserController {

    @GetMapping("/")
    String home() {
        return "<h1>Hello World!</h1>";
    }

    @GetMapping("/user")
    String user() {
        return "<h1>Hello World!</h1>";
    }

    @GetMapping("/admin")
    String admin() {
        return "<h1>Hello World!</h1>";
    }

}
