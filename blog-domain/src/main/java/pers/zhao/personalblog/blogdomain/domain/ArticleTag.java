package pers.zhao.personalblog.blogdomain.domain;

import lombok.Data;

import java.util.Date;

/**
 * 文章标签中间表
 * @author zhao
 */
@Data
public class ArticleTag {
    private Integer id;

    private Long articleId;

    private Integer tagId;

    private Date createTime;

    private Article article;

    private Tag tag;
}