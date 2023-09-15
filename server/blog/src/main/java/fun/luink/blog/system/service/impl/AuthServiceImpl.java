package fun.luink.blog.system.service.impl;

import fun.luink.blog.common.model.R;
import fun.luink.blog.common.model.LoginUser;
import fun.luink.blog.common.service.TokenService;
import fun.luink.blog.model.UserInfo;
import fun.luink.blog.system.repository.AuthRepository;
import fun.luink.blog.system.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    AuthRepository authRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private TokenService tokenService;


    @Override
    public R accountLogin(UserInfo user) {
        //使用spring-security认证登录
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getAccount(),user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);

        //如果认证没通过，给出对应的提示
        if(Objects.isNull(authenticate)){
            throw new RuntimeException("登录失败");
        }
        //登录通过，将生成令牌并存入redis
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        tokenService.createToken(loginUser);
        return R.success(loginUser);
    }

    @Override
    public R accountRegister(UserInfo userInfo) {

        //验证用户名是否在6-16位之间，且包含字母和数字
        if((userInfo.getAccount().length() < 6 || userInfo.getAccount().length() > 16)
                && !userInfo.getAccount().matches("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$")){
            return R.fail(400,"用户名长度应在6-16位之间，且用户名应包含字母和数字");
        }

        //验证用户名是否已存在
        UserInfo user = new UserInfo();
        user.setAccount(userInfo.getAccount());
        if(authRepository.exists(Example.of(user))){
            return R.fail(400,"用户名已存在");
        }


        String encode = passwordEncoder.encode(userInfo.getPassword());
        userInfo.setPassword(encode);
        UserInfo info = authRepository.save(userInfo);
        LoginUser loginUser = new LoginUser(){{
            setUserInfo(info);
        }};
        tokenService.createToken(loginUser);
        return new R(200,"注册成功",loginUser);
    }
}
