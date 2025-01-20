package com.bootcamp.myapp.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class FunRestController {
    
    @GetMapping("/")
    public String hello() {
        return "hello world";
    }
    
}