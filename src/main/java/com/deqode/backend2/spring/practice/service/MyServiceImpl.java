package com.deqode.backend2.spring.practice.service;

import com.deqode.backend2.spring.practice.models.Student;
import com.deqode.backend2.spring.practice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyServiceImpl implements MyService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return this.studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudent() {
        return this.studentRepository.findAll();
    }

    @Override
    public Student updateStudent(Student student, int id) {
        Student update = this.studentRepository.findById(id).get();
        update.setName(student.getName());
        update.setEmail(student.getEmail());
        update.setCity(student.getCity());
        update = this.studentRepository.save(update);
        return update;
    }

    @Override
    public void deleteStudent(int id) {
        this.studentRepository.deleteById(id);
    }
}
