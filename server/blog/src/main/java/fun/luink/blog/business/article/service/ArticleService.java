package fun.luink.blog.business.article.service;

import fun.luink.blog.common.model.R;
import fun.luink.blog.model.Article;
import java.lang.String;
import java.util.List;

public interface ArticleService {
  R getArticle(String id);

  R addArticle(Article article);

  R updateArticle(Article article);

  R delArticle(List<String> article);

  R getArticleList(Article article);
}
