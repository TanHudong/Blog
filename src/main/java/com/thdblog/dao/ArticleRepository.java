package com.thdblog.dao;

import com.thdblog.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author tanhudong
 * @mail 514390025@qq.com
 * @date 2018/10/2 23:36
 * @Description
 */
@Transactional(rollbackOn = Exception.class)
public interface ArticleRepository extends JpaRepository<Article,String> {

    // 通过类型找到所有文章
    List<Article> findAllByCategory(String category);

    // 通过标题找到所有文章
    List<Article> findAllByTitle(String title);
}
