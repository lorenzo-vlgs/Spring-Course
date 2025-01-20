package com.example.springcoredemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.springcoredemo.common.ICoach;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class DemoController {
    
    private ICoach myCoach;

    @Autowired
    public void setCoach(ICoach coach) {
        myCoach = coach;
    }

    @GetMapping("/dailyWorkout")
    public String getMethodName() {
        return myCoach.getDailyWorkout();
    }
    
}
