package com.example.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        // TODO Auto-generated method stub
        return "Practice fast bowling for 15min !!!!!";
    }
    
}
