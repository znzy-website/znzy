package com.example.backend.mapper;

import com.example.backend.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user WHERE name=#{name} AND password=#{password}")
    User login(String name, String password);

    @Select("SELECT * FROM user WHERE id = #{id}")
    User getUserById(Integer id);
}
