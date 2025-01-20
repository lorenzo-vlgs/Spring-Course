package com.example.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary //Makes this the injected bean no matter what (only if there isn't @Qualifier)
public class TrackCoach implements ICoach{

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k!";
    }
    
}
