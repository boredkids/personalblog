package pers.zhao.personalblog.bloggateway.mapper;

import java.util.List;
import pers.zhao.personalblog.blogdomain.domain.Counter;

public interface CounterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Counter record);

    Counter selectByPrimaryKey(Integer id);

    List<Counter> selectAll();

    int updateByPrimaryKey(Counter record);
}