package fun.luink.blog.model;

import fun.luink.blog.common.model.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("sys_menu")
@Schema(name = "菜单",title = "menu")
public class Menu extends BaseEntity {

    @Schema(title = "菜单名称")
    String menuName;

    @Schema(title = "菜单类型")
    String menuType;

    @Schema(title = "菜单URL")
    String menuUrl;

    @Schema(title = "菜单图标")
    String menuIcon;

    @Schema(title = "菜单顺序")
    Integer menuOrder;

    @Schema(title = "菜单状态")
    String menuStatus;

    @Schema(title = "菜单权限")
    String menuPermission;

    @Schema(title = "菜单父级")
    String menuParent;

}
