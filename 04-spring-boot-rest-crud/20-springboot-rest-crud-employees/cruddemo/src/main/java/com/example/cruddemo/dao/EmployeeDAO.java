package com.example.cruddemo.dao;

import java.util.List;

import com.example.cruddemo.entity.Employee;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee employee);

    void deleteById(int theId);
}
