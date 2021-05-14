package com.bjpowernode.finance.mapper;

import com.bjpowernode.finance.entity.UserPermissions;
import com.bjpowernode.finance.entity.UserPermissionsExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserPermissionsMapper {
    long countByExample(UserPermissionsExample example);

    int deleteByExample(UserPermissionsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserPermissions record);

    int insertSelective(UserPermissions record);

    List<UserPermissions> selectByExample(UserPermissionsExample example);

    UserPermissions selectByPrimaryKey(Integer id);

    List<UserPermissions> selectByExampleWithUserAndPermission(UserPermissionsExample example);

    UserPermissions selectByPrimaryKeyWithUserAndPermission(Integer id);

    int updateByExampleSelective(@Param("record") UserPermissions record, @Param("example") UserPermissionsExample example);

    int updateByExample(@Param("record") UserPermissions record, @Param("example") UserPermissionsExample example);

    int updateByPrimaryKeySelective(UserPermissions record);

    int updateByPrimaryKey(UserPermissions record);
}