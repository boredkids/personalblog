package pers.zhao.personalblog.blogdomain.domain;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 分类
 * @author zhao
 */
@Data
public class Category {
    private Integer id;

    private String name;

    private Integer sort;

    private String path;

    private Integer pId;

    private Date createTime;

    private List<Article> articleList;
}