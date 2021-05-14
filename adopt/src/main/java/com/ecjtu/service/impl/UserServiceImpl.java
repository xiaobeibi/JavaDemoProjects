package com.ecjtu.service.impl;

import com.ecjtu.entity.Users;
import com.ecjtu.mapper.UsersMapper;
import com.ecjtu.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 */
@Service
public class UserServiceImpl implements UsersService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public int addUser(Users user) {
        int i = usersMapper.addUser(user);
        return i;
    }

    @Override
    public int deleteUser(Integer id) {
        int i = usersMapper.deleteUser(id);
        return i;
    }

    @Override
    public int updateUser(Users user) {
        int i = usersMapper.updateUser(user);
        return i;
    }

    @Override
    public List<Users> getUsers() {
        List<Users> users = usersMapper.getUsers();
        return users;
    }

    @Override
    public Users findById(Integer id) {
        Users byId = usersMapper.findById(id);
        return byId;
    }

    @Override
    public List<Users> findByName(String userName) {
        List<Users> byName = usersMapper.findByName(userName);
        return byName;
    }

    @Override
    public Users loginUser(Users users) {
        Users users1 = usersMapper.loginUser(users);
        return users1;
    }

    @Override
    public void deleteBatch(List<Integer> ids) {
        usersMapper.deleteBatch(ids);
    }
}
