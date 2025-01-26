package com.example.backend.mapper;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Date;

@Mapper
public interface LikeMapper {
    @Insert("INSERT INTO `like-re`(userId,articleId,time) VALUES (#{userId},#{articleId},#{time}) ")
    int addLike(Integer userId, Integer articleId,Date time);

    @Select("SELECT id FROM `like-re` WHERE userId=#{userId} AND articleId=#{articleId}")
    Integer checkLike(Integer userId, Integer articleId);

    @Delete("DELETE FROM `like-re` WHERE userId=#{userId} AND articleId=#{articleId}")
    int deleteLike(Integer userId, Integer articleId);
}
