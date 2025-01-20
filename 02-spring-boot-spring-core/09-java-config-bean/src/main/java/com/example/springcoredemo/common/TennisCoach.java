package com.example.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements ICoach{

    public TennisCoach() {
        System.out.println("In construsction: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }
    
}
