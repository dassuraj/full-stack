package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    @GetMapping("")
    public String index(){
        return "student-form";
    }
    @PostMapping("/save")
    public ResponseEntity<Student> save(@RequestBody Student student){
        if (student==null||student.getName()==null||
                student.getEmail()==null||student.getRollNumber()==null||student.getPhoneNumber()==null){
            return ResponseEntity.badRequest().body(null);
        }
        try {
            return ResponseEntity.ok(studentService.save(student));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @PostMapping("/find-all")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(studentService.findAll());
    }

    @GetMapping("/name-email")
    @ResponseBody
    public List<Object[]> getStudentNameAndEmail() {
        return studentService.getNameAndEmail();
    }
}
