package com.example.backend.mapper;

import com.example.backend.entity.Plan;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;

@Mapper
public interface PlanMapper {

    @Insert("INSERT INTO plan(userId,time,content) VALUES (#{userId},#{time},#{content})")
    int insertPlan(int userId, Date time, String content);

    //获取对应的计划
    @Select("SELECT * FROM plan WHERE userId=#{userId}")
    List<Plan> selectPlanByUserId(int userId);

    @Update("UPDATE plan SET Isfinish=!Isfinish WHERE userId=#{userId} AND id=#{id}")
    int FinishPlan(int userId, Integer id);
}
