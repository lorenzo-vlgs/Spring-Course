package com.example.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements ICoach{

    public TrackCoach() {
        System.out.println("In construsction: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k!";
    }
    
}
