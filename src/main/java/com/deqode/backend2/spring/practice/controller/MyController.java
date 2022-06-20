package com.deqode.backend2.spring.practice.controller;

import com.deqode.backend2.spring.practice.helper.JwtUtil;
import com.deqode.backend2.spring.practice.models.Student;
import com.deqode.backend2.spring.practice.models.StudentJwtRequest;
import com.deqode.backend2.spring.practice.models.StudentJwtResponse;
import com.deqode.backend2.spring.practice.service.MyService;
import com.deqode.backend2.spring.practice.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

    @GetMapping("/welcome")
    public String welcome(){
        return "successful login";
    }

    //////////////////////////////////////// JWT /////////////////////////////////////////////////

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/token")
    public ResponseEntity<?> generateToken(@RequestBody StudentJwtRequest student) throws Exception {
        System.out.println(student);
        try
        {
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(student.getUsername(),student.getPassword()));
        }catch (UsernameNotFoundException e){
            e.printStackTrace();
            throw new Exception("User Not found !!!");
        }catch (BadCredentialsException e){
            e.printStackTrace();
            throw new Exception("Bad Credentials !!!");
        }

        UserDetails userDetails = this.myUserDetailsService.loadUserByUsername(student.getUsername());

        String token = this.jwtUtil.generateToken(userDetails);
        System.out.println("JWT: "+token);
        return ResponseEntity.ok(new StudentJwtResponse(token));
    }

}
