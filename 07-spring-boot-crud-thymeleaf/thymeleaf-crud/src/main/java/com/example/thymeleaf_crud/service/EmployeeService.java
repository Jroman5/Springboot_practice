package com.example.thymeleaf_crud.service;

import java.util.List;

import com.example.thymeleaf_crud.entity.Employee;

public interface EmployeeService {
    

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void delete(int id);
}
