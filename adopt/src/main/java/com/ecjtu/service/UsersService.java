package com.ecjtu.service;

import com.ecjtu.entity.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 */
public interface UsersService {
    /**
     * 新增的用户
     * @param user 新增的用户
     * @return int
     * */
    int addUser(Users user);

    /**
     * 删除用户
     * @param id 用户的id
     * @return int
     * */
    int deleteUser(Integer id);

    /**
     * 更新用户的信息
     * @param user 更新的用户信息
     * @return int
     * */
    int updateUser(Users user);

    /**
     * 查询所有的用户
     * @return list
     * */
    List<Users> getUsers();

    /**
     * 根据用户id查询信息
     * @param id 用户id
     * @return users
     * */
    Users findById(Integer id);

    /**
     * 根据用户名查询用户信息
     * @param userName 用户名
     * @return users
     * */
    List<Users> findByName(String userName);

    /**
     * 用户登录
     * @param users 用户的账号和密码
     * @return Users
     * */
    Users loginUser(Users users);
    /**
     * 批量删除
     * @param ids id的集合
     * */
    void deleteBatch(@Param("ids")List<Integer>ids);
}
