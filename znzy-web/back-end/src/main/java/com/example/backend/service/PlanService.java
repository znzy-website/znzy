package com.example.backend.service;


import com.example.backend.entity.Plan;

import java.util.Date;
import java.util.List;

public interface PlanService {
    int insertPlan(int userId, Date time, String content);
    List<Plan> selectPlanByUserId(int userId);
    int FinishPlan(int userId, Integer id);
}
