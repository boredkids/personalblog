package pers.zhao.personalblog.bloggateway.mapper;

import java.util.List;
import pers.zhao.personalblog.blogdomain.domain.Tag;

public interface TagMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Tag record);

    Tag selectByPrimaryKey(Integer id);

    List<Tag> selectAll();

    int updateByPrimaryKey(Tag record);
}