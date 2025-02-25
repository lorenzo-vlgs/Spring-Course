package com.example.springcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class DemoController {
    
    private ICoach myCoach;

    @Autowired
    public DemoController(ICoach coach){
        myCoach = coach;
    }

    @GetMapping("/dailyWorkout")
    public String getMethodName() {
        return myCoach.getDailyWorkout();
    }
    
}
