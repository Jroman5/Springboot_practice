package com.example.thymeleaf_crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.thymeleaf_crud.entity.Employee;
import com.example.thymeleaf_crud.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository; 


    @Autowired
    public EmployeeServiceImpl(EmployeeRepository empRepo){
        this.employeeRepository = empRepo;

    }

    @Override
    public void delete(int id) {
        
        employeeRepository.deleteById(id);
        
    }

    @Override
    public List<Employee> findAll() {
        
        return employeeRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public Employee findById(int id) {
        
        return employeeRepository.getReferenceById(id);
    }

    @Override
    public Employee save(Employee employee) {
        
        return employeeRepository.save(employee);
    }
    
}
