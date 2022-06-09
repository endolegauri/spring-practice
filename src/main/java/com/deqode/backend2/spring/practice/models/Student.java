package com.deqode.backend2.spring.practice.models;

import lombok.Data;
import lombok.Generated;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Student")
public class Student {
    private int id;
    private String name;
    private String email;
    private String city;
}
