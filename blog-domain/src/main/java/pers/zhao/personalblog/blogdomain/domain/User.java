package pers.zhao.personalblog.blogdomain.domain;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 用户实体类
 * @author zhao
 */
@Data
public class User {
    private Long id;

    private String nickname;

    private String email;

    private String img;

    private Date createTime;

    private List<Comment> commentList;

    private List<Article> articleList;
}