package com.example.springcoredemo.common;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component //This makes the class a Spring Bean
@Scope("prototype")
public class CricketCoach implements ICoach{

    public CricketCoach() {
        System.out.println("In construsction: " + getClass().getSimpleName());
    }
    
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }
    
}
