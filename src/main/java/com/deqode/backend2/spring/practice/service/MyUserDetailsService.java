package com.deqode.backend2.spring.practice.service;

import com.deqode.backend2.spring.practice.models.Student;
import com.deqode.backend2.spring.practice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//        Student student = this.studentRepository.findByName(name);
//        return new User(student.getName(),student.getPassword(),new ArrayList<>());

        if (userName.equals("ABC")){
            return new User("ABC","abc@123",new ArrayList<>());
        }else {
            throw new UsernameNotFoundException("User not found !!!!");
        }
    }

}
