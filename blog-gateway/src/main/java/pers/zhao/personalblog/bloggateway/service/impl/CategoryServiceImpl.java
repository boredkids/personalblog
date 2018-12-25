package pers.zhao.personalblog.bloggateway.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.zhao.personalblog.blogdomain.domain.Category;
import pers.zhao.personalblog.bloggateway.mapper.CategoryMapper;
import pers.zhao.personalblog.bloggateway.service.CategoryService;

import java.util.List;

/**
 * @author zhao
 * @date 2018/12/25 16:43
 */
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;
    /**
     * 查询所有分类列表
     * @return
     */
    @Override
    public List<Category> selectAll() {
        return categoryMapper.selectAll();
    }
}
