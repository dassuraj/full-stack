package com.example.demo.serviceImpl;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public Student save(Student student) {
       return studentRepository.save(student);
    }

    @Override
    public List<Student> findAll() {
       return studentRepository.findAll();
    }

    @Override
    public List<Object[]> getNameAndEmail() {
        return studentRepository.findNameAndEmail();
    }
}
