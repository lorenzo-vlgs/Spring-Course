package com.example.springcoredemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

import com.example.springcoredemo.common.ICoach;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class DemoController {
    
    private ICoach myCoach;

    private ICoach anotherCoach;

    @Autowired
    public DemoController(  @Qualifier("cricketCoach") ICoach myCoach,
                            @Qualifier("cricketCoach") ICoach aCoach) {
        System.out.println("In construsction: " + getClass().getSimpleName());
        this.myCoach = myCoach;
        this.anotherCoach = aCoach;
    }

    @GetMapping("/dailyWorkout")
    public String getMethodName() {
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check(){
        return "Comparing beans: myCoach == anotherCoach, " + (myCoach == anotherCoach);
    }
}
