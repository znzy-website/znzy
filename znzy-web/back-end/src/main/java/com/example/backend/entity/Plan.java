package com.example.backend.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Plan {
    private Integer id,userId,Isfinish;
    private String content;
    private Date time;
}
