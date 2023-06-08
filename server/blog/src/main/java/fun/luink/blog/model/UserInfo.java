package fun.luink.blog.model;

import fun.luink.blog.common.model.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.*;

/**
 * 用户实体类
 */
@Data
@Document("sys_user")
@Schema(name = "用户",title = "UserInfo")
public class UserInfo extends BaseEntity {

    @Indexed(unique = true)
    @Schema(title = "登录用户名称")
    String account;//登录用户名称

    @Schema(title = "用户密码")
    String password;//密码

    @Schema(title = "用户邮箱")
    @Indexed(unique = true)
    String mail;//邮箱

    @Schema(title = "用户电话")
    @Indexed(unique = true)
    String phone;//电话

    @Schema(title = "用户头像")
    String photo;//头像

    @Schema(title = "用户简介")
    String introduction;//简介


}
