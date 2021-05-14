package com.bjpowernode.sys.mapper;

import com.bjpowernode.sys.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 */
public interface UserMapper {

    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /*
     *登录
     * */
    User login(User user);

    List<User> queryAllUser(User user);

    /**
     * 保存用户和角色的关系
     * @param userid
     * @param rid
     */
    void insertUserRole(@Param("uid") Integer userid, @Param("rid") Integer rid);
}
