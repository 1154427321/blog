package fun.luink.blog.config;

import fun.luink.blog.common.model.BaseEntity;
import fun.luink.blog.common.model.LoginUser;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

/**
 * mongoDB获取当前登录人信息
 *
 * @apiNote 用于JPA中的@LastModifiedBy和@CreatedBy注解获取登录人信息
 * @see BaseEntity
 */
public class MongoDBAuditorAware implements AuditorAware {


    @Override
    public Optional getCurrentAuditor() {
        //从security认证上下文中获取当前登录人信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return Optional.empty();
        }
        //提取用户名
        LoginUser principal = (LoginUser) authentication.getPrincipal();
        return Optional.of(principal.getUsername());
    }
}