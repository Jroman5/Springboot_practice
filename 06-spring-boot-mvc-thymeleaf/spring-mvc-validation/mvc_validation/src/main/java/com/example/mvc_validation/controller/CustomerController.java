package com.example.mvc_validation.controller;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.mvc_validation.model.Customer;

import jakarta.validation.Valid;

@Controller
public class CustomerController {

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
    


    @GetMapping("/customer-sign-on")
    public String customerSignIn(Model model){
        Customer tmpCutomer = new Customer();

        model.addAttribute("customer", tmpCutomer);

        return "customer-form";
    }

    @PostMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult){

        System.out.println(bindingResult);
        
        if(bindingResult.hasErrors()){
            return "customer-form";
        } else {
            System.out.println("Customer: " + customer.getFirstName() + " " + customer.getLastName() + " " +customer.getFreePasses() + " " + customer.getPostalCode());
            return "customer-confirmation";
        }
    }
}
