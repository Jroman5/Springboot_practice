package com.example.thymeleaf_crud.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.thymeleaf_crud.entity.Employee;
import com.example.thymeleaf_crud.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService empService;

    public EmployeeController(EmployeeService empService){
        this.empService = empService; 
    }

    @GetMapping("/list")
    public String listEmployees(Model theModel){
        List<Employee> employees = this.empService.findAll();  

        theModel.addAttribute("employees", employees);
        return "list-employees";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee emp){
        empService.save(emp);

        return "redirect:/employees/list";
    }

    @GetMapping("/employeeForm")
    public String employeeForm(Model theModel){
        
        Employee tmpEmployee = new Employee();

        theModel.addAttribute("employee", tmpEmployee);

        return "employees/employee-form";
    }

    @GetMapping("/showFormForUpdate")
    public String updateEmployee(@RequestParam("employeeId") int id, Model theModel){

        Employee emp = empService.findById(id);

        theModel.addAttribute("employee", emp);

        return "employees/employee-form";

    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int id){

        empService.delete(id);

        return "redirect:/employees/list";

    }

}
