package com.bjpowernode.employment.mapper;

import com.bjpowernode.employment.mapper.entity.User;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserMapper {
    List<User> getAllUsers(User user);
    User getUserById(String userId);
    User getUserByAccount(String userAccount);
    int addUser(User user);
    int updateUser(User user);
    int deleteUser(String userId);
}
