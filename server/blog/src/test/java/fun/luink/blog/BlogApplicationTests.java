package fun.luink.blog;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.signers.JWTSigner;
import cn.hutool.jwt.signers.JWTSignerUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

@SpringBootTest
class BlogApplicationTests {

    @Autowired
    PasswordEncoder passwordEncoder;

    // 令牌自定义标识
    @Value("${token.header}")
    private String header;

    // 令牌秘钥
    @Value("${token.secret}")
    private String secret;

    // 令牌有效期（默认30分钟）
    @Value("${token.expireTime}")
    private int expireTime;

    @Test
    void contextLoads() {
        String raw = "123456";
        String pwd = "$2a$10$FZDhmdl4dVBMMd000VfGt.A1/n/dIPluEbroLa7JhwWTXI4fv7lBq";
        System.out.println(passwordEncoder.matches(raw, pwd));
    }

    @Test
    void token(){
        KeyPair pair = SecureUtil.generateKeyPair("RSA");
        PublicKey publicKey = pair.getPublic();
        PrivateKey privateKey = pair.getPrivate();

        JWTSigner privateSigner = JWTSignerUtil.rs256(privateKey);

        JWTSigner publicSigner = JWTSignerUtil.rs256(publicKey);

        String user = JWT.create()
                .setSigner(privateSigner)
                .setPayload("user", "888")
                .sign();

        boolean verify = JWT.of(user).setSigner(publicSigner).verify();

    }

    @Autowired
    MongoTemplate mongoTemplate;

    


}
