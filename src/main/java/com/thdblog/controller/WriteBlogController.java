package com.thdblog.controller;

import com.thdblog.dto.ResponseResult;
import com.thdblog.entity.Article;
import com.thdblog.entity.Category;
import com.thdblog.service.ArticleService;
import com.thdblog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author tanhudong
 * @mail 514390025@qq.com
 * @date 2018/10/4 15:27
 * @Description
 */
@Controller
@RequestMapping("/admin/write")
public class WriteBlogController {

    @Autowired
    CategoryService categoryService;
    @Autowired
    ArticleService articleService;

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    @RequestMapping(value = { "", "/", "/index" }, method = { RequestMethod.GET, RequestMethod.POST })
    public String index() {
        return "admin/write";
    }

    @RequestMapping(value = "/submit",method = RequestMethod.POST)
    public String submit(Article article){
        // 获取到文章的类型
        String name = article.getCategory().getName();
        System.out.println("categotyNmae::::::"+name);
        Category category = categoryService.findByName(name);
        System.out.println("category::::::"+category);
        article.setCategory(category);
        // 文章发布的时间
        article.setDate(simpleDateFormat.format(new Date()));
        if (article.getContent().length()>40){
            // 如果文章篇幅长度大于40，取前40个字符为文章摘要
            article.setSummary(article.getContent().substring(0,40));
        }else {
            // 文章篇幅长度小于40，取全部文字为文章篇幅
            article.setSummary(article.getContent());
        }
        // 第一次默认都是为0
        article.setNumberOfViews(0);
        articleService.save(article);
        return "redirect:/admin/blog";
    }

    @RequestMapping(value = "/save")
    public String save(Article article){

        System.out.println("点击了发布键！");
        // 获取到文章的类型
        String name = article.getCategory().getName();
        System.out.println("categotyNmae::::::"+name);
        Category category = categoryService.findByName(name);
        System.out.println("category::::::"+category);
        article.setCategory(category);
        // 文章发布的时间
        article.setDate(simpleDateFormat.format(new Date()));
        if (article.getContent().length()>40){
            // 如果文章篇幅长度大于40，取前40个字符为文章摘要
            article.setSummary(article.getContent().substring(0,40));
        }else {
            // 文章篇幅长度小于40，取全部文字为文章篇幅
            article.setSummary(article.getContent());
        }
        // 第一次默认都是为0
        article.setNumberOfViews(0);
        articleService.save(article);
        return "redirect:/admin/write";
    }
}
