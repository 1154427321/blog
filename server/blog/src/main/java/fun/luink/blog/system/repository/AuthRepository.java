package fun.luink.blog.system.repository;

import fun.luink.blog.model.UserInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 认证相关仓库
 */

public interface AuthRepository extends MongoRepository<UserInfo,String> {
}
