package pers.zhao.personalblog.bloggateway.dao;

import java.util.List;
import pers.zhao.personalblog.blogdomain.domain.Category;

public interface CategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    Category selectByPrimaryKey(Integer id);

    List<Category> selectAll();

    int updateByPrimaryKey(Category record);
}