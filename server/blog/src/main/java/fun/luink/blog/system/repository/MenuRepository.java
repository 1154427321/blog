package fun.luink.blog.system.repository;

import fun.luink.blog.model.Menu;
import java.lang.String;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MenuRepository extends MongoRepository<Menu, String> {
}
