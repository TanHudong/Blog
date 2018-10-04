package com.thdblog.controller;

import com.thdblog.entity.Article;
import com.thdblog.entity.Category;
import com.thdblog.service.ArticleService;
import com.thdblog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author tanhudong
 * @mail 514390025@qq.com
 * @date 2018/10/4 15:32
 * @Description
 */
@Controller
@RequestMapping("/admin/blog")
public class BlogController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    ArticleService articleService;

    /**
     * 获取所有的文章信息，传输给model
     * @param model
     * @return
     */
    @RequestMapping(value = {"","/","/index"},method = {RequestMethod.POST,RequestMethod.GET})
    public String index(Model model){
        List<Article> articles = articleService.list();
        model.addAttribute("articles",articles);
        return "admin/blog";
    }

    @RequestMapping(value = "/write")
    public String write(Model model){
        List<Category> categories = categoryService.list();
        model.addAttribute("categories",categories);
        model.addAttribute("article",new Article());
        return "admin/write";
    }

    /**
     * 删除博客
     * @param id
     * @return
     */
    @RequestMapping("delete/{id}")
    public String delete(@PathVariable("id") String id){
        articleService.delete(id);
        return "redirect:/admin";
    }

    @RequestMapping("update/{id}")
    public String update(@PathVariable("id") String id,Model model){
        Article article = articleService.getById(id);
        model.addAttribute("target",article);
        List<Category> categories = categoryService.list();
        model.addAttribute("categories",categories);
        model.addAttribute("article",new Article());
        return "admin/update";
    }
}
