package com.bootcamp.myapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    
    @GetMapping("/")
    public String sayHello(){
        return "Hello World!";
    }

    @GetMapping("/workout")
    public String doWorkout(){
        return "Run a hard 5k!";
    }

    @GetMapping("/fortune")
    public String getFortune(){
        return "Today is your lucky day!";
    } 
}
