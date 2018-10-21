package com.thdblog.dao;

import com.thdblog.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;


/**
 * @author tanhudong
 * @mail 514390025@qq.com
 * @date 2018/10/2 23:33
 * @Description
 */
@Transactional(rollbackOn = Exception.class)
public interface CategoryRepository extends JpaRepository<Category,String> {

    Category findByName(String name);
}
