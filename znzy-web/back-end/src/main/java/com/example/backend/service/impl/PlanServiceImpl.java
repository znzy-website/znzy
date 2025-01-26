package com.example.backend.service.impl;

import com.example.backend.entity.Plan;
import com.example.backend.mapper.PlanMapper;
import com.example.backend.service.PlanService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {
    @Resource
    PlanMapper planMapper;

    @Override
    public int insertPlan(int userId, Date time, String content) {
        return planMapper.insertPlan(userId, time, content);
    }

    @Override
    public List<Plan> selectPlanByUserId(int userId) {
        return planMapper.selectPlanByUserId(userId);
    }

    @Override
    public int FinishPlan(int userId, Integer id) {
        return planMapper.FinishPlan(userId,id);
    }
}
