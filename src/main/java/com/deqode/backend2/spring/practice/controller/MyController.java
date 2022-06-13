package com.deqode.backend2.spring.practice.controller;

import com.deqode.backend2.spring.practice.models.Student;
import com.deqode.backend2.spring.practice.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class MyController {

    @Autowired
    private MyService myService;

    @PostMapping("/")
    public ResponseEntity<?> addStudent(@RequestBody Student student){
        Student save = this.myService.saveStudent(student);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/")
    public List<Student> getAllStudent(){
        return this.myService.getAllStudent();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@RequestBody Student student ,@PathVariable("id") int id){
        Student update = this.myService.updateStudent(student,id);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable("id") int id){
        this.myService.deleteStudent(id);
        return id+"th Student deleted successfully";
    }







//    @PostMapping("/")
//    public ResponseEntity<?> addStudent(@RequestBody Student student){
//        Student save = this.studentRepository.save(student);
//        return ResponseEntity.ok(save);
//    }
//
//    @GetMapping("/")
//    public List<Student> getStudents(){
//        return this.studentRepository.getAllStudents();
//    }
//
//    //new branch created
//
//    @PutMapping("/{id}")
//    public ResponseEntity<?> updateStudent(@RequestBody Student student ,@PathVariable int id){
//
//        Student studentToUpdate = this.studentRepository.findById(id).get();
//        studentToUpdate.setName(student.getName());
//        studentToUpdate.setCity(student.getCity());
//        studentToUpdate.setEmail(student.getEmail());
//        Student update = this.studentRepository.save(student);
//        return ResponseEntity.ok(update);
//    }
//
//    @DeleteMapping("/{id}")
//    public String  deleteStudent(@PathVariable("id") int id){
//        this.studentRepository.deleteById(id);
//        return id +"th Student deleted" ;
//    }

}
