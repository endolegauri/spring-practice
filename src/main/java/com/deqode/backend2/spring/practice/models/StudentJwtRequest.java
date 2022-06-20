package com.deqode.backend2.spring.practice.models;

import lombok.Data;

@Data
public class StudentJwtRequest {
    String username;
    String password;
}
