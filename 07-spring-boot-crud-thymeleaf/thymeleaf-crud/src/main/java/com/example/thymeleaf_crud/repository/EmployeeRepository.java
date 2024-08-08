package com.example.thymeleaf_crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.thymeleaf_crud.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
    
    public List<Employee> findAllByOrderByLastNameAsc();
}
