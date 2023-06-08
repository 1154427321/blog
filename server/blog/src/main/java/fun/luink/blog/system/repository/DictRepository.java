package fun.luink.blog.system.repository;

import fun.luink.blog.model.Dict;
import java.lang.String;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DictRepository extends MongoRepository<Dict, String> {
}
