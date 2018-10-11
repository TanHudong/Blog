package com.thdblog.controller;

import com.thdblog.entity.Article;
import com.thdblog.entity.Category;
import com.thdblog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tanhudong
 * @mail 514390025@qq.com
 * @date 2018/10/4 15:13
 * @Description
 */
@Controller
@RequestMapping(value = "/admin")
public class ManageHomeController {

    @Autowired
    CategoryService categoryService;

    /**
     * 首页刷新
     * @return
     */
    @RequestMapping(value = {"","/","/index"},method = {RequestMethod.POST,RequestMethod.GET})
    public String dashboard(){
        return "admin/index";
    }

//    /**
//     * 跳转到博客管理界面
//     * @return
//     */
//    @RequestMapping(value = "/blog",method = {RequestMethod.POST,RequestMethod.GET})
//    public String toBlogManagement(){
//        return "admin/blog";
//    }
//
//    /**
//     * 跳转到类型管理界面
//     * @return
//     */
//    @RequestMapping(value = "/category",method = {RequestMethod.POST,RequestMethod.GET})
//    public String toCategoryManagement(){
//        return "admin/category";
//    }

    @RequestMapping(value = "/write")
    public String write(@ModelAttribute("article")Article article, Model model){
        System.out.println("点击了写博客的按钮！");
        List<Category> categories = categoryService.list();
        model.addAttribute("categories",categories);
        return "admin/write";
    }
}
