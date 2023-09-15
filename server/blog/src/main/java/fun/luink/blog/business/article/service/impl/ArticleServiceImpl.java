package fun.luink.blog.business.article.service.impl;

import fun.luink.blog.business.article.repository.ArticleRepository;
import fun.luink.blog.business.article.service.ArticleService;
import fun.luink.blog.common.model.R;
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
  public R getArticle(String id) {
    return R.success(articleRepository.findById(id));
  }

  @Override
  public R addArticle(Article article) {
    Article save = articleRepository.insert(article);
    return R.success(save);
  }

  @Override
  public R updateArticle(Article article) {
    Article save = articleRepository.save(article);
    return R.success(save);
  }

  @Override
  public R delArticle(List<String> ids) {
    articleRepository.deleteAllById(ids);
    return R.success();
  }

  @Override
  public R getArticleList(Article article) {
    return R.success(articleRepository.findAll(Example.of(article)));
  }
}
