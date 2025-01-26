package com.example.backend.controller;

import com.example.backend.entity.RestBean;
import com.example.backend.entity.User;
import com.example.backend.service.UserService;
import com.example.backend.util.JWTUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth/")
public class AuthController {
    @Resource
    UserService userService;

    @PostMapping("/login")
    public RestBean<String> login(@RequestParam("username") String username,
                                @RequestParam("password") String password,
                                HttpSession session) { // 注入 HttpServletRequest
        User user = userService.login(username, password);
        if (user != null) {
            user.setPassword("*");
            // 将用户信息存储到 session 中
            session.setAttribute("user", user);
            return RestBean.success("登录成功！", JWTUtil.createToken(user));
        } else {
            return RestBean.failure(503, "登录失败！");
        }
    }
}
