package com.example.backend.mapper;

import com.example.backend.entity.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ArticleMapper {
    @Insert("INSERT INTO article(authorId,title,content,time) VALUES (#{authorId}, #{title}, #{content}, #{time})")
    int insertArticle(Article article);

    @Select("SELECT id,title,authorId,likes,favorites,views,substring(content,1,120) AS content  FROM article ORDER BY id DESC LIMIT 50")
    List<Article> getAllArticles();

    @Select("SELECT * FROM article WHERE id=#{id}")
    Article getArticleById(int id);

    //增加观看量
    @Update("UPDATE article SET views=views+1 WHERE id=#{id}")
    int incrementArticleViews(int id);

    //点赞
    @Update("UPDATE article SET likes=likes+1 WHERE id=#{id}")
    int incrementArticleLikes(int id);
    //取消点赞
    @Update("UPDATE article SET likes=likes-1 WHERE id=#{id} ")
    int decrementArticleLikes(int id);

    //收藏
    @Update("UPDATE article SET favorites=favorites+1 WHERE id=#{id}")
    int incrementArticleFavorites(int id);
    //取消收藏
    @Update("UPDATE article SET favorites=favorites-1 WHERE id=#{id} ")
    int decrementArticleFavorites(int id);


}
