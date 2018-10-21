package com.thdblog.service.impl;

import com.thdblog.dao.CategoryRepository;
import com.thdblog.dto.ServiceResult;
import com.thdblog.entity.Category;
import com.thdblog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author tanhudong
 * @mail 514390025@qq.com
 * @date 2018/10/2 23:50
 * @Description
 */
@Service
@Transactional(rollbackOn = Exception.class)
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> list() {
        List<Category> categories = categoryRepository.findAll();
        return categories;
    }

    @Override
    public ServiceResult createCategory(Category category) {
        ServiceResult serviceResult;

        Category savedCategory = categoryRepository.save(category);
        if (savedCategory.getId()!=null){
            serviceResult = new ServiceResult(true,"成功创建类型！","category",savedCategory);
        }else{
            serviceResult = new ServiceResult(false,"创建类型时发生错误！");
        }
        return serviceResult;
    }

    @Override
    public ServiceResult deleteCategoryById(String id) {
        ServiceResult serviceResult;
        categoryRepository.delete(id);
        Category category = categoryRepository.findOne(id);
        if(null==category){
            serviceResult = new ServiceResult(true,"成功删除类型！");
        }else {
            serviceResult = new ServiceResult(false,"删除类型时发生错误！");
        }
        return serviceResult;
    }

    @Override
    public ServiceResult modifyCategory(Category category) {
        ServiceResult serviceResult;
        Category modifyCategory = categoryRepository.save(category);
        if (null!=modifyCategory){
            serviceResult = new ServiceResult(true,"类型信息修改成功！");
        }else{
            serviceResult = new ServiceResult(false,"类型信息修改失败！");
        }
        return  serviceResult;
    }

    @Override
    public Category get(String id) {
        Category category = categoryRepository.findOne(id);
        return category;
    }

    @Override
    public Category findByName(String name) {
        Category category = categoryRepository.findByName(name);
        if (category==null){
            System.out.println("没有这个类型");
        }
        return category;
    }
}
