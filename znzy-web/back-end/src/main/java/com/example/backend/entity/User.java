package com.example.backend.entity;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String name,password,avatar,email;
}
