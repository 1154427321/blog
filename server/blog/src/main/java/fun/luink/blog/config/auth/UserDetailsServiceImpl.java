package fun.luink.blog.config.auth;

import fun.luink.blog.common.model.LoginUser;
import fun.luink.blog.model.UserInfo;
import fun.luink.blog.system.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 实现spring-security用户服务
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    AuthRepository authRepository;

    /**
     * 实现spring-security从数据库加载用户方法
     * @return 返回userDetails
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = new UserInfo();
        userInfo.setAccount(username);

        LoginUser userDetails = new LoginUser();
        Optional<UserInfo> one = authRepository.findOne(Example.of(userInfo));
        userDetails.setUserInfo(one.get());
        return userDetails;
    }
}
