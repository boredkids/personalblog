package pers.zhao.personalblog.bloggateway.dao;

import java.util.List;
import pers.zhao.personalblog.blogdomain.domain.Comment;

public interface CommentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Comment record);

    Comment selectByPrimaryKey(Long id);

    List<Comment> selectAll();

    int updateByPrimaryKey(Comment record);
}