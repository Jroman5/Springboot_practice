package com.example.databaseDemo.dao;
import java.util.List;

import com.example.databaseDemo.enitity.Student;

public interface StudentDAO {
    void save(Student student);
    Student findById(Integer id);

    List<Student> findAll();

    void update(Student student);

    void delete(Integer id);
}
