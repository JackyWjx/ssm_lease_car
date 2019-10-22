package cn.wjx.sys.mapper;


import cn.wjx.sys.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    /**
     * 登陆
     */
    User login(User user);

    List<User> queryAllUser(User user);

    void insertUserRole(@Param("uid") Integer userId,@Param("rid") Integer rid);
}