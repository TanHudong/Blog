package com.thdblog.service.impl;

import com.thdblog.dao.ArticleRepository;
import com.thdblog.dto.ServiceResult;
import com.thdblog.entity.Article;
import com.thdblog.entity.Category;
import com.thdblog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author tanhudong
 * @mail 514390025@qq.com
 * @date 2018/10/2 23:51
 * @Description
 */
@Service
@Transactional(rollbackOn = Exception.class)
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    ArticleRepository articleRepository;

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    @Override
    public Article getById(String id) {
        Article article = articleRepository.findOne(id);
        return article;
    }

    @Override
    public List<Article> list() {
        List<Article> articles = articleRepository.findAll();
        return articles;
    }

    @Override
    public List<Article> getArticleByCategoryName(Category category) {
        List<Article> articles = articleRepository.findAllByCategory(category);
        return articles;
    }

    @Override
    public ServiceResult delete(String id) {
        ServiceResult serviceResult;
        articleRepository.delete(id);
        Article article = articleRepository.findOne(id);
        if (null==article){
            serviceResult = new ServiceResult(true,"博客删除成功!");
        }else {
            serviceResult = new ServiceResult(false,"博客删除失败!");
        }
        return serviceResult;
    }

    @Override
    public void save(Article article) {
        articleRepository.save(article);
    }

    @Override
    public List<Article> getArticlesByTitle(String title) {
        List<Article> articles = articleRepository.findAllByTitle(title);
        return articles;
    }
}
