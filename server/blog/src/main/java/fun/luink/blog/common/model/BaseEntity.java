package fun.luink.blog.common.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public abstract class BaseEntity implements Serializable {

    @Id
    @Schema(title = "id")
    String id;

    @CreatedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(title = "创建时间")
    Date CreateTime;

    @CreatedBy
    @Schema(title = "创建人")
    String createUser;

    @LastModifiedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(title = "修改时间")
    Date updateTime;

    @LastModifiedBy
    @Schema(title = "修改人")
    String updateUser;

    @Field
    @Schema(title = "逻辑删除标识")
    Boolean delFlag = false;

    @Field
    @Schema(title = "备注")
    String mark;

    @Transient
    @Schema(title = "页码")
    Integer pageNum;

    @Transient
    @Schema(title = "每页条数")
    Integer pageSize;

}
