package com.example.springcoredemo.common;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component //This makes the class a Spring Bean
public class CricketCoach implements ICoach{

    public CricketCoach() {
        System.out.println("In construsction: " + getClass().getSimpleName());
    }
    
    // define our init method
    @PostConstruct
    public void init(){
        System.out.println("In init():" + getClass().getSimpleName());
    }
    // define our destroy method
    @PreDestroy
    public void destroy(){
        System.out.println("In destroy(): " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }
    
}
