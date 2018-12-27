package pers.zhao.personalblog.blogdomain.domain;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 文章
 * @author zhao
 */
@Data
public class Article {
    private Long id;

    private String name;

    private Integer categoryId;

    private Boolean isHot;

    private Long authorId;

    private Integer clickNumId;

    private String img;

    private Date createTime;

    private Date updateTime;

    private String content;

    private User user;

    private Category category;

    private List<Comment> commentList;

    private List<Tag> tagList;
}