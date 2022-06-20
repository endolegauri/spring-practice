package com.deqode.backend2.spring.practice.models;

import lombok.Data;

@Data
public class StudentJwtResponse {
    String token;

    public StudentJwtResponse(String token) {
        this.token = token;
    }
}
