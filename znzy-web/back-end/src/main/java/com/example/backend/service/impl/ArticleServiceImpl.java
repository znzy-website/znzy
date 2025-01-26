package com.example.backend.service.impl;

import com.example.backend.entity.Article;
import com.example.backend.entity.User;
import com.example.backend.entity.UserAndArticle;
import com.example.backend.mapper.ArticleMapper;
import com.example.backend.mapper.LikeMapper;
import com.example.backend.mapper.UserMapper;
import com.example.backend.service.ArticleService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Resource
    ArticleMapper articleMapper;
    @Resource
    UserMapper userMapper;
    @Resource
    LikeMapper likeMapper;



    @Override
    public int InsertArticle(Article article) {
        return articleMapper.insertArticle(article);
    }

    @Override
    public List<UserAndArticle> getAllArticles() {

        List<UserAndArticle> AllArticles = new ArrayList<>();
        for(Article article : articleMapper.getAllArticles()){
            User user=userMapper.getUserById(article.getAuthorId());//原本写的是article.getId()
            AllArticles.add(new UserAndArticle(user,article.getId(),article.getTitle(), article.getContent(),article.getLikes(),article.getFavorites(),article.getViews()));
        }
        return AllArticles;
    }

    @Override
    public Article getArticleById(Integer userId,Integer id) {
        int a=articleMapper.incrementArticleViews(id);
        Integer answer=likeMapper.checkLike(userId,id);
        Article article=articleMapper.getArticleById(id);
        if (answer==null)article.setIsLike(0);
        else article.setIsLike(1);
        return article;
    }

    @Override
    public int incrementArticleLikes(Integer id) {
        return articleMapper.incrementArticleLikes(id);
    }

    @Override
    public int addLike(Integer userId, Integer articleId, Date time) {
        return likeMapper.addLike(userId, articleId,time);
    }

    @Override
    public Integer checkLike(Integer userId, Integer articleId) {
        Integer answer=likeMapper.checkLike(userId,articleId);
        Article article=articleMapper.getArticleById(articleId);
        if (answer==null)article.setIsLike(0);
        else article.setIsLike(1);
        if (answer!=null)return 1;
        else return 0;
    }

    @Override
    public int decrementArticleLikes(Integer id) {
        return articleMapper.decrementArticleLikes(id);
    }

    @Override
    public int deleteArticle(Integer userId, Integer articleId) {
        return likeMapper.deleteLike(userId, articleId);
    }
}
