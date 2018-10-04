package com.thdblog.service;

import com.thdblog.dto.ServiceResult;
import com.thdblog.entity.Category;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author tanhudong
 * @mail 514390025@qq.com
 * @date 2018/10/2 23:38
 * @Description
 */
@Transactional(rollbackOn = Exception.class)
public interface CategoryService {

    /**
     * 查询所有类型
     * @return
     */
    public List<Category> list();

    /**
     * 新建一个类型
     * @param category
     * @return 服务结果
     */
    public ServiceResult createCategory(Category category);

    /**
     * 通过id获取一个类型
     * @param id
     * @return
     */
    public Category get(String id);

    /**
     * 根据类型名称获取一个类型
     * @param name
     * @return
     */
    public Category findByName(String name);
}
