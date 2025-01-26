package com.example.backend.service;

import com.example.backend.entity.Article;
import com.example.backend.entity.UserAndArticle;

import java.util.Date;
import java.util.List;

public interface ArticleService {
    int InsertArticle(Article article);
    List<UserAndArticle> getAllArticles();
    Article getArticleById(Integer userId,Integer id);

    int incrementArticleLikes(Integer id);
    int addLike(Integer userId, Integer articleId, Date time);
    Integer checkLike(Integer userId, Integer articleId);
    int decrementArticleLikes(Integer id);
    int deleteArticle(Integer userId, Integer articleId);
}
