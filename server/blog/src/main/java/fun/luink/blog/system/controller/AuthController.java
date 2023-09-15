package fun.luink.blog.system.controller;

import fun.luink.blog.common.model.R;
import fun.luink.blog.model.UserInfo;
import fun.luink.blog.system.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 认证相关controller
 */
@RestController
@RequestMapping("/auth")
@Tag(name = "认证相关接口")
public class AuthController {

    @Resource
    AuthService authService;

    /**
     * 账号登录接口
     * @param userInfo
     * @return
     */
    @Operation(summary = "登录",description = "账号登录接口")
    @PostMapping("accountLogin")
    public R accountLogin(@RequestBody UserInfo userInfo){


        return authService.accountLogin(userInfo);
    }

    /**
     * 账号注册接口
     * @param userInfo
     * @return
     */
    @Operation(summary = "注册",description = "账号注册接口")
    @PostMapping("accountRegister")
    public R accountRegister(@RequestBody UserInfo userInfo){

        return authService.accountRegister(userInfo);
    }
}
