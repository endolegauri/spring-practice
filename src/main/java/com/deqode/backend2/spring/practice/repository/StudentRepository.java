package com.deqode.backend2.spring.practice.repository;

import com.deqode.backend2.spring.practice.models.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student,Integer> {

    Student findByName(String name);
}
