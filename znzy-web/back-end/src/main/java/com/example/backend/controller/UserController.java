package com.example.backend.controller;

import com.example.backend.entity.RestBean;
import com.example.backend.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    @Resource
    UserService userService;

    @PostMapping("/login")
    public RestBean<String> login(@RequestParam("username") String username,
                                  @RequestParam("password") String password) {
        int status=userService.login(username, password);
        if(status>=1)return RestBean.success("登陆成功！");
        else return RestBean.failure(503,"登陆失败！");
    }
}
