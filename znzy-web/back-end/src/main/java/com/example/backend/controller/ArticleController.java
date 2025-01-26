package com.example.backend.controller;


import com.example.backend.entity.Article;
import com.example.backend.entity.RestBean;
import com.example.backend.entity.UserAndArticle;
import com.example.backend.service.ArticleService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/article")
public class ArticleController {

    @Resource
    ArticleService articleService;

    @PostMapping("addArticle")
    public RestBean<String> addArticle(@RequestParam("id") Integer id,
                                       @RequestParam("title") String title,
                                       @RequestParam("content") String content) {
//        HttpSession session=request.getSession();
        int status = articleService.InsertArticle(new Article(id, title, content,new Date()));
        if(status ==1)return RestBean.success("发布成功！");
        else return RestBean.failure(503,"发布失败！");
    }

    @GetMapping("getAllArticle")
    public RestBean<List<UserAndArticle>> getAllArticle() {
        return RestBean.success("获取成功！",articleService.getAllArticles());
    }

    @GetMapping("getArticleById")
    public RestBean<Article> getArticleById(@RequestParam("id") Integer id,
                                            HttpServletRequest request) {
        int userId = (Integer) request.getAttribute("id");
        System.out.println(request.getAttribute("user"));
        return RestBean.success("获取成功！",articleService.getArticleById(userId,id));
    }

    @PostMapping("checkIsLike")
    public RestBean<Integer> checkIsLike(@RequestParam("id") Integer id,
                                         HttpServletRequest request) {
        int userId = (Integer) request.getAttribute("id");
        int a=articleService.checkLike(userId,id);
        return  RestBean.success("操作成功！",a);
    }

    @PostMapping("like")
    public RestBean<String> likeArticle(@RequestParam("id") Integer id,
                                        HttpServletRequest request) {
        int userId = (Integer) request.getAttribute("id");
        int status = articleService.incrementArticleLikes(id);
        if(status ==1&&articleService.addLike(userId,id,new Date())>=1)return RestBean.success("点赞成功！");
        else return RestBean.failure(503,"点赞失败！");
    }

    @PostMapping("unlike")
    public RestBean<String> unlikeArticle(@RequestParam("id") Integer id,
                                          HttpServletRequest request) {
        int userId = (Integer) request.getAttribute("id");
        int status = articleService.decrementArticleLikes(id);
        if(status ==1&&articleService.deleteArticle(userId,id)>=1)return RestBean.success("取消点赞成功！");
        else return RestBean.failure(503,"取消点赞失败！");
    }
}
