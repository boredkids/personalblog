package pers.zhao.personalblog.bloggateway.mapper;

import java.util.List;
import pers.zhao.personalblog.blogdomain.domain.User;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    User selectByPrimaryKey(Long id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
}