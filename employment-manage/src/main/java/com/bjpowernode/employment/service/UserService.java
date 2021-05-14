package com.bjpowernode.employment.service;

import com.bjpowernode.employment.mapper.entity.User;
import java.util.List;

public interface UserService {
    List<User> getAllUsers(User user, int pageNum, int pageSize);
    User getUserById(String userId);
    User getUserByAccount(String userAccount);
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(String userId);
}
