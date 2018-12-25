package pers.zhao.personalblog.bloggateway.service;

import pers.zhao.personalblog.blogdomain.domain.Category;

import java.util.List;

/**
 * 分类服务层
 * @author zhao
 * @date 2018/12/25 16:40
 */
public interface CategoryService {
    /**
     * 查询所有分类列表
     * @return
     */
    public List<Category> selectAll();
}
