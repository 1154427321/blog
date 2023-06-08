package fun.luink.blog.business.article.service.impl;

import fun.luink.blog.business.article.repository.ArticleRepository;
import fun.luink.blog.business.article.service.ArticleService;
import fun.luink.blog.common.model.ResultObj;
import fun.luink.blog.model.Article;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {
  @Autowired
  ArticleRepository articleRepository;

  @Override
  public ResultObj getArticle(String id) {
    return ResultObj.success(articleRepository.findById(id));
  }

  @Override
  public ResultObj addArticle(Article article) {
    Article save = articleRepository.insert(article);
    return ResultObj.success(save);
  }

  @Override
  public ResultObj updateArticle(Article article) {
    Article save = articleRepository.save(article);
    return ResultObj.success(save);
  }

  @Override
  public ResultObj delArticle(List<String> ids) {
    articleRepository.deleteAllById(ids);
    return ResultObj.success();
  }

  @Override
  public ResultObj getArticleList(Article article) {
    return ResultObj.success(articleRepository.findAll(Example.of(article)));
  }
}
