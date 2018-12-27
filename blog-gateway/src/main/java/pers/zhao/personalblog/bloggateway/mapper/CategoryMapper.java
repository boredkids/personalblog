package pers.zhao.personalblog.bloggateway.mapper;

import java.util.List;

import com.jarvis.cache.annotation.Cache;

import com.jarvis.cache.annotation.CacheDelete;
import com.jarvis.cache.annotation.CacheDeleteKey;
import pers.zhao.personalblog.blogdomain.domain.Category;

public interface CategoryMapper {

    @CacheDelete({ @CacheDeleteKey(value = "'select-all-' + #args[0].id",condition = "#retVal > 0")})
    int deleteByPrimaryKey(Integer id);

    @CacheDelete({ @CacheDeleteKey(value = "'select-all-' + #args[0].id",condition = "#retVal > 0")})
    int insert(Category record);

    Category selectByPrimaryKey(Integer id);

    @Cache(expire = 6000,key = "'select-all-' + #args[0]")
    List<Category> selectAll();

    @CacheDelete({ @CacheDeleteKey(value = "'select-all-' + #args[0].id",condition = "#retVal > 0")})
    int updateByPrimaryKey(Category record);
}