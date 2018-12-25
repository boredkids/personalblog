package pers.zhao.personalblog.bloggateway.dao;

import java.util.List;
import pers.zhao.personalblog.blogdomain.domain.Article;

public interface ArticleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Article record);

    Article selectByPrimaryKey(Long id);

    List<Article> selectAll();

    int updateByPrimaryKey(Article record);
}