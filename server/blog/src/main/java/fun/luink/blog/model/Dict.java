package fun.luink.blog.model;

import fun.luink.blog.common.model.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Schema(name = "字典",title = "dict")
@Document("sys_dict")
public class Dict extends BaseEntity {

    @Schema(title = "字典类型")
    String dictType;

    @Schema(title = "字典Label")
    String dictLabel;

    @Schema(title = "字典Value")
    String dictValue;
}
