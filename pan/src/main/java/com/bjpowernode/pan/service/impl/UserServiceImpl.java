package com.bjpowernode.pan.service.impl;

import com.bjpowernode.pan.dao.UserMapper;
import com.bjpowernode.pan.dao.model.User;
import com.bjpowernode.pan.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 *
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public int alterPassword(String userName, String password) {
        User user = this.userMapper.queryUserByUsername(userName);
        user.setPassWord(password);
        return this.userMapper.alterSecret(user);
    }

    @Override
    public int add(User user) {
        return this.userMapper.add(user);
    }

    @Override
    public int update(User user) {
        return this.userMapper.update(user);
    }

    @Override
    public int deleteByIds(String[] ids) {
        return this.userMapper.deleteByIds(ids);
    }

    @Override
    public int deleteByUsernames(String[] userNames) {
        return this.userMapper.deleteByUsernames(userNames);
    }

    @Override
    public User queryUserByUsername(String userName) {
        return this.userMapper.queryUserByUsername(userName);
    }

    @Override
    public List<User> queryUserList(Map<String, Object> params) {
        return this.userMapper.queryUserList(params);
    }
}