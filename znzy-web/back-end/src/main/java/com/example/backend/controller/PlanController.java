package com.example.backend.controller;


import com.example.backend.entity.Plan;
import com.example.backend.entity.RestBean;
import com.example.backend.service.PlanService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping ("/api/plan")
public class PlanController {
    @Resource
    PlanService planService;

    @PostMapping("/addplan")
    public RestBean<String> addPlan(@RequestParam("content") String content,
                                    HttpServletRequest request) {
        int userId = (Integer) request.getAttribute("id");
        int status=planService.insertPlan(userId, new Date(),content);
        if (status > 0) {
            return RestBean.success("添加计划成功");
        } else {
            return RestBean.failure(401,"添加计划失败");
        }
    }

    @GetMapping("AllPlan")
    public RestBean<List<Plan>> getAllPlan(HttpServletRequest request) {
        int userId = (Integer) request.getAttribute("id");
        return RestBean.success("cg",planService.selectPlanByUserId(userId));
    }

    @PostMapping("/finish")
    public RestBean<String> finishPlan(@RequestParam("id") int id,
                                    HttpServletRequest request) {
        int userId = (Integer) request.getAttribute("id");
        int status = planService.FinishPlan( userId,id);
        if (status > 0) {
            return RestBean.success("已完成");
        } else {
            return RestBean.failure(401,"未完成");
        }

    }
}
