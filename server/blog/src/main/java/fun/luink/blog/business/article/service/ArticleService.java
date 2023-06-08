package fun.luink.blog.business.article.service;

import fun.luink.blog.common.model.ResultObj;
import fun.luink.blog.model.Article;
import java.lang.String;
import java.util.List;

public interface ArticleService {
  ResultObj getArticle(String id);

  ResultObj addArticle(Article article);

  ResultObj updateArticle(Article article);

  ResultObj delArticle(List<String> article);

  ResultObj getArticleList(Article article);
}
