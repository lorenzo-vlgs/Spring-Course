package com.example.springcoredemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.springcoredemo.common.SwimCoach;

@Configuration //This class will be used to create the Beans of the models or components not annotated in their class
public class EntetiesContext {
    
    @Bean("aquatic")
    public SwimCoach newSwimCoach(){
        return new SwimCoach();
    }
}
