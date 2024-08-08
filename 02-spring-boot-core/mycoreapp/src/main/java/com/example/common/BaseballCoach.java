package com.example.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class BaseballCoach implements Coach{

    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("in mystartupstuff(): " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout(){
        return "pitch 25 fastballs";
    }

    @PreDestroy
        public void doMyDestroyStuff(){
        System.out.println("in mydestroytstuff(): " + getClass().getSimpleName());
    }
    
}
