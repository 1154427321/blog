package fun.luink.blog.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * SpringDoc配置类
 */
@Configuration
public class SpringDocConfig {

    //获取token的请求头名称
    @Value("${token.header}")
    private String headerName;

    @Bean
    public OpenAPI restfulOpenAPI() {
        return new OpenAPI()
                //添加认证信息
                .components(new Components().addSecuritySchemes(headerName, new SecurityScheme()
                                        .type(SecurityScheme.Type.APIKEY)
                                        .scheme("basic")
                                        .name(headerName)
                                        .in(SecurityScheme.In.HEADER)
                                        .description("请求头")))
                //添加全局认证
                .addSecurityItem(new SecurityRequirement().addList(headerName))
                //文档信息
                .info(new Info().title("个人博客")
                        .description("个人博客系统API")
                        .version("v0.0.1")
                        .contact(new Contact().name("luink")))
                //文档许可证信息
                .externalDocs(new ExternalDocumentation()
                        .description("SpringDoc Wiki Documentation")
                        .url("https://springdoc.org/v2"));
    }

}