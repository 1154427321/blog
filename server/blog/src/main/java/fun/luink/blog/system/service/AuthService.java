package fun.luink.blog.system.service;


import fun.luink.blog.common.model.ResultObj;
import fun.luink.blog.model.UserInfo;

/**
 * 认证服务
 */
public interface AuthService {

    ResultObj accountLogin(UserInfo userInfo);

    ResultObj accountRegister(UserInfo userInfo);
}
