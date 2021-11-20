package xktz.website.global.user.dao;

import org.apache.ibatis.annotations.Mapper;
import xktz.website.global.user.User;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> selectUsers();

    User selectById(Integer id);

    User selectByEmail(String email);

    int deleteById(Integer id);

    int insert(User record);

    int updateById(User record);

    int updateByIdSelective(User record);
}