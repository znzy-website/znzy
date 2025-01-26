package com.example.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Data
public class Article {
    private Integer id,authorId,likes,favorites,views;
    private String title, content,ispublic;
    private Date time;
    @Setter
    private Integer IsLike,IsFavorite;

    public Article() {
        // Default constructor for Jackson deserialization
    }

    public Article(int id, String title, String content, Date date) {
        this.title = title;
        this.content = content;
        this.time = date;
        this.authorId = id; // Placeholder value, should be fetched from database
    }
}
