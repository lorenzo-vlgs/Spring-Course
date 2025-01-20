package com.bootcamp.myapp.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    
    // Inject properties for: coach.name and team.name
    @Value("${coach.name}")
    private String coachName;
    @Value("${team.name}")
    private String teamName;

    // new endpoint for team info
    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return "Coach:" + coachName + ", Team name: " + teamName;
    }
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
