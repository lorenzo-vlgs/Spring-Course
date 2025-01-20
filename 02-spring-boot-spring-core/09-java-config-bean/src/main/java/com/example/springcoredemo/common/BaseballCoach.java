package com.example.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements ICoach{

    public BaseballCoach() {
        System.out.println("In construsction: " + getClass().getSimpleName());
    }
    
    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes in batting practice";
    }
    
}
