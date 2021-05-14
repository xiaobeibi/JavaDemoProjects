package com.bjpowernode.employment.service.impl;

import com.github.pagehelper.PageHelper;
import com.bjpowernode.employment.mapper.UserMapper;
import com.bjpowernode.employment.mapper.entity.User;
import com.bjpowernode.employment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> getAllUsers(User user, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return userMapper.getAllUsers(user);
    }

    @Override
    public User getUserById(String userId) {
        return userMapper.getUserById(userId);
    }

    @Override
    public User getUserByAccount(String userAccount) {
        return userMapper.getUserByAccount(userAccount);
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public void deleteUser(String userId) {
        userMapper.deleteUser(userId);
    }
}
