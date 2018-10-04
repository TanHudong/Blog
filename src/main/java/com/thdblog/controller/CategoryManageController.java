package com.thdblog.controller;

import com.thdblog.dto.CategoryForm;
import com.thdblog.dto.ResponseResult;
import com.thdblog.dto.ServiceResult;
import com.thdblog.entity.Category;
import com.thdblog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.Column;
import java.text.ParseException;
import java.util.List;

/**
 * @author tanhudong
 * @mail 514390025@qq.com
 * @date 2018/10/4 22:45
 * @Description
 */
@Controller
@RequestMapping("/admin/category")
public class CategoryManageController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = {"","/","/index"},method = {RequestMethod.POST,RequestMethod.GET})
    public String index(Model model){
        List<Category> categories = categoryService.list();
        model.addAttribute("categories",categories);
        return "/admin/category_manage";
    }

    @RequestMapping(value = "/createCategory",method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult<Category> createCategory(@RequestBody CategoryForm categoryForm) throws ParseException{
        System.out.println("运行到createCategory了");
        Category category = new Category();
        category.setName(categoryForm.getCategoryName());
        category.setDisplayName(categoryForm.getCategoryDisplayName());
        ServiceResult serviceResult = categoryService.createCategory(category);
        return ResponseResult.from(serviceResult,"category");
    }

}
