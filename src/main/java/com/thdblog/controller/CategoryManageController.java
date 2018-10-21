package com.thdblog.controller;

import com.thdblog.dto.CategoryForm;
import com.thdblog.dto.ResponseResult;
import com.thdblog.dto.ServiceResult;
import com.thdblog.entity.Category;
import com.thdblog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


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
        return "admin/category_manage";
    }

    /**
     * 创建一个类型
     * @param categoryForm
     * @return
     * @throws ParseException
     */
    @RequestMapping(value = "/createCategory",method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult<Category> createCategory(@RequestBody CategoryForm categoryForm) throws ParseException{
        System.out.println("运行到createCategory了");
        // 创建一个新的类型
        Category category = new Category();
        category.setName(categoryForm.getCategoryName());
        category.setDisplayName(categoryForm.getCategoryDisplayName());
        ServiceResult serviceResult = categoryService.createCategory(category);
        return ResponseResult.from(serviceResult,"category");
    }

    /**
     * 删除类型
     * @param categoryId 类型id
     * @return 服务结果
     * @throws ParseException
     */
    @RequestMapping(value = "/deleteCategory",method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult<Object> deleteCategory(@RequestParam("categoryId") String categoryId) throws ParseException{
        ServiceResult serviceResult = categoryService.deleteCategoryById(categoryId);
        return ResponseResult.from(serviceResult,"category");
    }

    @RequestMapping(value = "/modifyCategory",method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult<Category> editCategory(@RequestBody CategoryForm categoryForm) throws ParseException{
        Category category = new Category();
        category.setId(categoryForm.getId());
        category.setName(categoryForm.getCategoryName());
        category.setDisplayName(categoryForm.getCategoryDisplayName());
        ServiceResult serviceResult = categoryService.modifyCategory(category);
        return ResponseResult.from(serviceResult);
    }
}
