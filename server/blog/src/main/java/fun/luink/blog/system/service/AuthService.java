package fun.luink.blog.system.service;


import fun.luink.blog.common.model.R;
import fun.luink.blog.model.UserInfo;

/**
 * 认证服务
 */
public interface AuthService {

    R accountLogin(UserInfo userInfo);

    R accountRegister(UserInfo userInfo);
}
