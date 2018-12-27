package pers.zhao.personalblog.blogdomain.domain;

import lombok.Data;

import java.util.Date;
/**
 * 评论实体类
 * @author zhao
 */
@Data
public class Comment {
    private Long id;

    private String content;

    private Long articleId;

    private Integer authorId;

    private Date createTime;

    private User user;

    private Article article;
}