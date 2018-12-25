package pers.zhao.personalblog.bloggateway.mapper;

import java.util.List;
import pers.zhao.personalblog.blogdomain.domain.ArticleTag;

public interface ArticleTagMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ArticleTag record);

    ArticleTag selectByPrimaryKey(Integer id);

    List<ArticleTag> selectAll();

    int updateByPrimaryKey(ArticleTag record);
}