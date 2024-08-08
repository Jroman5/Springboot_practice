package com.example.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.common.Coach;

@RestController
public class DemoController {

    private Coach myCoach;

    @Autowired
    public DemoController(
        @Qualifier("aquatic")Coach myCoach){
            System.out.println("In Constructor: " + getClass().getSimpleName());
        this.myCoach = myCoach;
        

    }

    @GetMapping("/getworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

    
    
}
