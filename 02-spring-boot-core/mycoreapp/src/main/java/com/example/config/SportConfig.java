package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.common.Coach;
import com.example.common.SwimCoach;


// creates a method that allows "third party classes to be instatiated as a bean" 
// does this by calling the constructor of the object through a meathod that is labeled as a bean
// essentially works as a wrapper for third party objects and allows you ton configure them in the same file
// bean id defaults to meathod name

@Configuration
public class SportConfig{

    //value passed to bean becomes its id the method name is used otherwise
    @Bean("aquatic")
    public Coach swimCoach(){
        return new SwimCoach();
    }

}