package com.example.backend.entity;

import lombok.Data;

import java.util.Date;

@Data
public class UserAndArticle {
    private User user;
    private Article article;
    private Integer id,likes,favorites,views;
    private String title, content,ispublic,AuthorName;
    private Date time;

    public UserAndArticle(User user, Integer id,String title,String content,Integer likes,Integer favorites,Integer views) {
        this.user = user;
        this.id = id;
        this.title = title;
        this.content = content;
        this.likes = likes;
        this.favorites = favorites;
        this.views = views;
    }
}
