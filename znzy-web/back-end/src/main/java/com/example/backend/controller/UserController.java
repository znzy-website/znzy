package com.example.backend.controller;

import com.example.backend.entity.RestBean;
import com.example.backend.entity.User;
import com.example.backend.service.UserService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Resource
    UserService userService;

    @GetMapping("information")
    public RestBean<User> getMyInfo(HttpServletRequest request){//没有正确的令牌的话进不去，所以不用判断是不是空了
//        if(session.getAttribute("user")==null)return RestBean.failure(401,"未登陆~");
        User theUser=userService.getUserById((Integer) request.getAttribute("id"));
        theUser.setPassword(null);
        //获取键为user的值
        return RestBean.success("获取成功！",theUser);
    }

    @GetMapping("getUserById")
    public RestBean<User> getUserById(@RequestParam("id") Integer id){
        User theUser=userService.getUserById(id);
        theUser.setPassword(null);
        return RestBean.success("获取成功！",theUser);
    }
}
