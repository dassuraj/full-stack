package com.example.demo.service;

import com.example.demo.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    Student save(Student student);

    List<Student> findAll();
    public List<Object[]> getNameAndEmail();
}
