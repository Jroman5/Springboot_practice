package com.example.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;

import jakarta.annotation.PostConstruct;
;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> students = new ArrayList<>();

    @PostConstruct
    public void loadData(){

        students.add(new Student("bob", "bouy"));
        students.add(new Student("billy", "BOBBY"));
        students.add(new Student("clif", "ford"));
        

    }
    
    @GetMapping("/students")
    public List<Student> getStudents(){
        

        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        if (studentId > students.size()-1 || (studentId < 0)) {
            throw new StudentNotFoundException("Student id not found - " + studentId);    
        }
        return students.get(studentId);

    }

    
}
