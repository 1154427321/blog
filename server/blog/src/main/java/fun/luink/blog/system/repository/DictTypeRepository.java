package fun.luink.blog.system.repository;

import fun.luink.blog.model.DictType;
import java.lang.String;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DictTypeRepository extends MongoRepository<DictType, String> {
}
