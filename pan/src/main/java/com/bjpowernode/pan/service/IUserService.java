package com.bjpowernode.pan.service;

import com.bjpowernode.pan.dao.model.User;

import java.util.List;
import java.util.Map;

/**
 *
 */
public interface IUserService {
    int alterPassword(String userName, String secret);

    int add(User user);

    int update(User user);

    int deleteByIds(String[] ids);

    int deleteByUsernames(String[] userNames);

    User queryUserByUsername(String userName);

    List<User> queryUserList(Map<String, Object> params);
}
