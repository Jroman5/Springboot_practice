package com.example.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cruddemo.dao.EmployeeRepository;
import com.example.cruddemo.entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl( EmployeeRepository theEmployeeDAO){
        this.employeeRepository = theEmployeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        // TODO Auto-generated method stub
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        return employeeRepository.getReferenceById(theId);
    }

    @Transactional
    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Transactional
    @Override
    public void delete(int theId) {
        employeeRepository.deleteById(theId);
    }
    
}
