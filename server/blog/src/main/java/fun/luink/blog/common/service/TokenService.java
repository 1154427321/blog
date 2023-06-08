package fun.luink.blog.common.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.signers.JWTSignerUtil;
import fun.luink.blog.common.CacheConstants;
import fun.luink.blog.common.RedisCache;
import fun.luink.blog.common.model.LoginUser;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * token验证处理
 *
 */
@Component
public class TokenService
{
    // 令牌自定义标识
    @Value("${token.header}")
    private String header;

    // 令牌有效期（默认30分钟）
    @Value("${token.expireTime}")
    private int expireTime;

    protected static final long MILLIS_SECOND = 1000;

    protected static final long MILLIS_MINUTE = 60 * MILLIS_SECOND;

    private static final Long MILLIS_MINUTE_TEN = 20 * 60 * 1000L;

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private PublicKey publicKey;

    @Autowired
    private PrivateKey privateKey;



    /**
     * 获取请求token
     *
     * @param request
     * @return token
     */
    public String getToken(HttpServletRequest request){
        return request.getHeader(header);
    }

    public String getUserAgent(HttpServletRequest request){
        return request.getHeader("user-agent");
    }


    public LoginUser getLoginUser(HttpServletRequest request){
        String token = getToken(request);
        String cacheKey = getTokenKey(token);
        if (StrUtil.isNotBlank(token)) {
            return redisCache.getCacheObject(cacheKey);
        }
        return null;
    }

    /**
     * 创建token
     * @param loginUser
     * @return
     */
    public String createToken(LoginUser loginUser) {
        String token = createToken();
        loginUser.setToken(token);
        refreshToken(loginUser);
        return token;
    }

    public String createToken(){
        return JWT.create()
                .setSigner(JWTSignerUtil.rs256(privateKey))
                .sign();
    }
    //todo 删除redis中的令牌


    /**
     * 验证令牌有效期，相差不足20分钟，自动刷新缓存
     *
     * @param loginUser
     * @return 令牌
     */
    public void verifyToken(LoginUser loginUser)
    {
        //过期时间
        Long expireTime = loginUser.getExpireTime();
        //当前时间
        Long currentTime = System.currentTimeMillis();

        //过期前20分钟刷新token
        if (expireTime - currentTime <= MILLIS_MINUTE_TEN)
        {
            refreshToken(loginUser);
        }
    }

    /**
     * 刷新令牌有效期
     *
     * @param loginUser 登录信息
     */
    public void refreshToken(LoginUser loginUser)
    {
        loginUser.setLoginTime(System.currentTimeMillis());
        loginUser.setExpireTime(loginUser.getLoginTime() + expireTime * MILLIS_MINUTE);
        // 根据uuid将loginUser缓存
        String userKey = getTokenKey(loginUser.getToken());
        redisCache.setCacheObject(userKey, loginUser, expireTime, TimeUnit.MINUTES);
    }

    /**
     * 获取缓存key
     * @param token
     * @return
     */
    private String getTokenKey(String token)
    {
        return CacheConstants.LOGIN_TOKEN_KEY + token;
    }



}
