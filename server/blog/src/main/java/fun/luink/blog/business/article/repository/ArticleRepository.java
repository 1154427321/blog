package fun.luink.blog.business.article.repository;

import fun.luink.blog.model.Article;
import java.lang.String;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArticleRepository extends MongoRepository<Article, String> {
}
