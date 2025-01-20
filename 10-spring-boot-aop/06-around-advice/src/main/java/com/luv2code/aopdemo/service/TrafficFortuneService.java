package com.luv2code.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

@Service
public class TrafficFortuneService implements IFortune{
    
    @Override
    public String getFortune() {
        
        // simulate a delay
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // return a fortune
        return "Excepect heavy traffic this morning.";
    }

    @Override
    public String getFortune(boolean tripWire) {
        
        if(tripWire){
            throw new RuntimeException("Major accident! Highway is closed!");
        }

        return getFortune();
    }
    
}
