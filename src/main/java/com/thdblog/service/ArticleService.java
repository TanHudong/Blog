package com.thdblog.service;

import com.thdblog.dto.ServiceResult;
import com.thdblog.entity.Article;
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
public interface ArticleService {

    /**
     * 通过id得到一个文章
     * @param id
     * @return
     */
    public Article getById(String id);

    /**
     * 得到所有的文章列表
     * @return
     */
    public List<Article> list();

    /**
     * 通过类型名称得到文章列表
     * @param category 文章类型
     * @return
     */
    public List<Article> getArticleByCategoryName(Category category);

    /**
     * 通过id删除文章
     * @param id
     */
    public ServiceResult delete(String id);

    /**
     * 保存文章
     * @param article
     */
    public void save(Article article);

    /**
     * 通过名称得到文章列表
     * @param title
     * @return
     */
    public List<Article> getArticlesByTitle(String title);
}
