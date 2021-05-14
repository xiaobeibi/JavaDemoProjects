package com.bjpowernode.finance.service.impl;

import com.bjpowernode.finance.entity.UserPermissions;
import com.bjpowernode.finance.entity.UserPermissionsExample;
import com.bjpowernode.finance.mapper.UserPermissionsMapper;
import com.bjpowernode.finance.service.UserPermissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserPermissionsServiceImpl implements UserPermissionsService {

    @Autowired
    UserPermissionsMapper userPermissionsMapper;

    @Override
    public List<UserPermissions> selectUserPermissionsByUserId(Integer userId) {
        UserPermissionsExample userPermissionsExample = new UserPermissionsExample();
        userPermissionsExample.createCriteria().andUseridEqualTo(userId);
        return userPermissionsMapper.selectByExampleWithUserAndPermission(userPermissionsExample);
    }

    @Override
    public UserPermissions selectUserPermissionsByPermissionId(Integer permissionId) {
        UserPermissionsExample userPermissionsExample = new UserPermissionsExample();
        userPermissionsExample.createCriteria().andPermissionidEqualTo(permissionId);
        return null;
    }

    @Override
    @Transactional
    public Integer insertUserPermissions(UserPermissions userPermissions) {
        return userPermissionsMapper.insertSelective(userPermissions);
    }

    @Override
    @Transactional
    public Integer UpdateUserPermissions(UserPermissions userPermissions) {
        return userPermissionsMapper.updateByPrimaryKeySelective(userPermissions);
    }

    @Override
    @Transactional
    public Integer deleteUserPermissionsByPermissionId(Integer permissionId) {
        UserPermissionsExample userPermissionsExample = new UserPermissionsExample();
        userPermissionsExample.createCriteria().andPermissionidEqualTo(permissionId);
        return userPermissionsMapper.deleteByExample(userPermissionsExample);
    }

    @Override
    public Integer deleteAllUserPermissionsByUserId(Integer userId) {
        UserPermissionsExample userPermissionsExample = new UserPermissionsExample();
        userPermissionsExample.createCriteria().andUseridEqualTo(userId);
        return userPermissionsMapper.deleteByExample(userPermissionsExample);
    }
}
