package com.example.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component //This makes the class a Spring Bean  
public class CricketCoach implements ICoach{

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }
    
}
