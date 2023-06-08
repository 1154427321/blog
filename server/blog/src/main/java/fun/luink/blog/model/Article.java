package fun.luink.blog.model;

import fun.luink.blog.common.model.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("sys_article")
@Schema(name = "文章",title = "article")
public class Article extends BaseEntity {

    @Schema(title = "标题")
    String title;

    @Schema(title = "内容")
    String content;

    @Schema(title = "作者")
    String author;

    @Schema(title = "类型")
    String type;

    @Schema(title = "标签")
    String tag;

    @Schema(title = "摘要")
    String summary;

    @Schema(title = "封面")
    String cover;

    //TODO: 之后改为实体类集合
    @Schema(title = "评论")
    String comment;

    @Schema(title = "点赞")
    Integer like;

    @Schema(title = "浏览")
    Integer view;

    @Schema(title = "置顶")
    Boolean top;

    @Schema(title = "推荐")
    Boolean recommend;

    @Schema(title = "原文链接")
    String original;

}
