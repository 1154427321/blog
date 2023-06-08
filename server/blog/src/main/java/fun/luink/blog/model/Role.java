package fun.luink.blog.model;

import fun.luink.blog.common.model.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("sys_role")
@Schema(name = "角色",title = "role")
public class Role extends BaseEntity {

    @Schema(title = "角色名称")
    String roleName;

    @Schema(title = "角色权限字符串")
    String roleKey;
}
