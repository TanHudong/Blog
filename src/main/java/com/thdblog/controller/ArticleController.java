package com.thdblog.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.thdblog.entity.Article;
import com.thdblog.entity.Category;
import com.thdblog.service.ArticleService;
import com.thdblog.service.CategoryService;
import org.omg.CORBA.TRANSACTION_MODE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tautua.markdownpapers.Markdown;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;

/**
 * @author tanhudong
 * @mail 514390025@qq.com
 * @date 2018/10/15 20:43
 * @Description 文章控制器 -- 即呈现给游客的相关页面操作
 */

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;
    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = {"","/index"})
    public String articleIndex(Model model){
        List<Article> articles = articleService.list();
        model.addAttribute("articles",articles);
        return "front/index";
    }

    /**
     * 按类型显示博客
     * @param displayName
     * @param category
     * @param model
     * @return
     */
    @RequestMapping("/column/{displayName}/{category}")
    public String columnPage(@PathVariable("displayName") String displayName,@PathVariable("category") String category, Model model){
        Category searchedCategory = categoryService.findByName(category);
        model.addAttribute("articles",articleService.getArticleByCategoryName(searchedCategory));
        model.addAttribute("displayName",displayName);
        return "front/columnPage";
    }

    /**
     * 显示详细信息
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/detail/{id}")
    public String detail(@PathVariable("id") String id, Model model){
        System.out.println(id);
        Article article = articleService.getById(id);
        System.out.println(article.getId());
        Markdown markdown = new Markdown();
        try {
            StringWriter out = new StringWriter();
            markdown.transform(new StringReader(article.getContent()),out);
            out.flush();
            article.setContent(out.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
        model.addAttribute("article",article);
        return "front/detail";
    }
}
