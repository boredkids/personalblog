package pers.zhao.personalblog.blogdomain.domain;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 博客正文
 * @author zhao
 */
@Data
public class Article {
    private Long id;

    private String name;

    private Integer categoryId;

    private Boolean isHot;

    private Long authorId;

    private Integer clickNum;

    private String img;

    private Date createTime;

    private Date updateTime;

    private String content;

    private List<Comment> Comments;

    private List<Tag> tagList;
}