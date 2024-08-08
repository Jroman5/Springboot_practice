package com.example.thymeleaf_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HelloWorldController {
    //method to show form
    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    //method to process form
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    //controller to read form data
    //add data to the model
    @RequestMapping(value="/processFormVersionTwo", method=RequestMethod.GET)
    public String letsShoutDude(HttpServletRequest request, Model model){

        //read params form html form

        String theName = request.getParameter("studentName");

        theName = theName.toUpperCase();

        String result = "Yo! " + theName;

        //convert data to upper case

        //create message 
        //add message to the model

        model.addAttribute("message", result);

        return "helloWorld";
    }

    @RequestMapping(value="/processFormVersionThree", method= RequestMethod.POST)
    public String processFormVersionThree (@RequestParam("studentName") String theName, Model model){

        //read params form html form

        // String theName = request.getParameter("studentName");

        theName = theName.toUpperCase();

        String result = "Hey my friend from v3: " + theName;

        //convert data to upper case

        //create message 
        //add message to the model

        model.addAttribute("message", result);

        return "helloWorld";
    }
}
