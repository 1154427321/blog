package fun.luink.blog.config;

import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.KeyUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.AsymmetricAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

@Configuration
public class KeyCofig {


    @Value("${token.publicKey}")
    private String publicKeyStr;

    @Value("${token.privateKey}")
    private String privateKeyStr;


    /**
     * 将字符串解码为密钥
     * @return
     */
    @Bean
    public PublicKey getPublicKey() {
        return KeyUtil.generatePublicKey(AsymmetricAlgorithm.RSA.getValue(), Base64.decode(publicKeyStr));
    }

    @Bean
    public PrivateKey getPrivateKey() {
        return KeyUtil.generateRSAPrivateKey(Base64.decode(privateKeyStr));
    }

    /**
     * 创建RSA公钥私钥
     */
    private static void createRSA(){
        //使用rsa算法
        KeyPair pair = SecureUtil.generateKeyPair("RSA");
        //将公钥和私钥进行base64编码，以方便使用
        System.out.println("公钥："+Base64.encode(pair.getPublic().getEncoded()));
        System.out.println("私钥："+Base64.encode(pair.getPrivate().getEncoded()));
    }

    public static void main(String[] args) {
        createRSA();
    }
}
