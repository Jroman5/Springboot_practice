package com.example.thymeleaf_demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.thymeleaf_demo.model.Student;

@Controller
public class StudentController {

    

    @Value("${countries}")
    private List<String> countries;

    @Value("${languages}")
    private List<String> languages;

    @Value("${systems}")
    private List<String> systems;
    
    @GetMapping("/showStudentForm")
    public String showForm(Model theModel){
        

        Student theStudent = new Student();

        theModel.addAttribute("student", theStudent);
        theModel.addAttribute("countries",countries);
        theModel.addAttribute("languages", languages);
        theModel.addAttribute("systems", systems);
        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent){
        //log inputdata

        System.out.println("TheStudent: " + theStudent.getFirstName() + " " + theStudent.getLastName() + " Country: " + theStudent.getCountry() + " favoriteLanguage: " + theStudent.getFavoriteLanguage()+ " favoriteSystem: " + theStudent.getFavoriteSystem());
        return "student-confirmation";

    }
}
