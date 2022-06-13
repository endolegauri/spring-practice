package com.deqode.backend2.spring.practice.repository;

import com.deqode.backend2.spring.practice.models.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StudentRepository extends MongoRepository<Student,Integer> {

}
