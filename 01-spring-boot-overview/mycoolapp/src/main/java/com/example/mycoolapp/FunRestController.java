package com.example.mycoolapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FunRestController {

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/")
    public String sayHello(){
        return "hello world!";
    }

    @GetMapping("/workout")
    public Workout getDailyWorkout(){
        return new Workout("run a 5k");
    }

    @GetMapping("/fortune")
    public String getDailyFortune(){
        return "you are really lucky";
    }

    @GetMapping("/coach")
    public String getCoach(){
        return coachName;
    }

    @GetMapping("/teaminfo")
    public String getTeam(){
        return "Coach: "+ coachName + " team: " + teamName;
    }
}
