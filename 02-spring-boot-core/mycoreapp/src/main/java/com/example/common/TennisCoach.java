package com.example.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    
    @Override
    public String getDailyWorkout(){
        return "serve 30 times";
    }
}
