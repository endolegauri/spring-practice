package com.deqode.backend2.spring.practice.service;

import com.deqode.backend2.spring.practice.models.Student;

import java.util.List;

public interface MyService {
    Student saveStudent(Student student);

    List<Student> getAllStudent();

    Student updateStudent(Student student, int id);

    void deleteStudent(int id);
}
