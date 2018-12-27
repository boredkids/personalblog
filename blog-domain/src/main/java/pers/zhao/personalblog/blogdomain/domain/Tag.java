package pers.zhao.personalblog.blogdomain.domain;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 标签类
 * @author zhao
 */
@Data
public class Tag {
    private Integer id;

    private String name;

    private Integer categoryId;

    private Date createTime;

    private Category category;

    private List<Article> articleList;
}