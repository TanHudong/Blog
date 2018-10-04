package com.thdblog.service.impl;

import com.thdblog.dao.ArticleRepository;
import com.thdblog.entity.Article;
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
    public List<Article> getArticleByCategoryName(String categoryName) {
        List<Article> articles = articleRepository.findAllByCategory(categoryName);
        return articles;
    }

    @Override
    public void delete(String id) {
        articleRepository.delete(id);
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
