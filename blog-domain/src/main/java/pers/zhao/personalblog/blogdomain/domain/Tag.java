package pers.zhao.personalblog.blogdomain.domain;

import java.util.Date;
import java.util.List;

/**
 * 标签实体类
 * @author zhao
 */
public class Tag {
    private Integer id;

    private String name;

    private Integer categoryId;

    private Date createTime;

    private List<Article> articleList;
}