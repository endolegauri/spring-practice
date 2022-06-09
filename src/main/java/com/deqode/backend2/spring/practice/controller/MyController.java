package com.deqode.backend2.spring.practice.controller;

import com.deqode.backend2.spring.practice.models.Student;
import com.deqode.backend2.spring.practice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class MyController {
    @Autowired
    private StudentRepository studentRepository;
    @PostMapping("/")
    public ResponseEntity<?> addStudent(@RequestBody Student student){
        Student save = this.studentRepository.save(student);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/")
    public List<Student> getStudents(){
        return this.studentRepository.findAll();
    }

//    @GetMapping("/")
//    public ResponseEntity<?> getStudents(){
//        return ResponseEntity.ok(this.studentRepository.findAll());
//    }
}
