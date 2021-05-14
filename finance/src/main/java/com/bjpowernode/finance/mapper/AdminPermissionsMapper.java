package com.bjpowernode.finance.mapper;

import com.bjpowernode.finance.entity.AdminPermissions;
import com.bjpowernode.finance.entity.AdminPermissionsExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminPermissionsMapper {
    long countByExample(AdminPermissionsExample example);

    int deleteByExample(AdminPermissionsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AdminPermissions record);

    int insertSelective(AdminPermissions record);

    List<AdminPermissions> selectByExample(AdminPermissionsExample example);

    AdminPermissions selectByPrimaryKey(Integer id);

    List<AdminPermissions> selectByExampleWithAdminAndPermissions(AdminPermissionsExample example);

    AdminPermissions selectByPrimaryKeyWithAdminAndPermissions(Integer id);

    int updateByExampleSelective(@Param("record") AdminPermissions record, @Param("example") AdminPermissionsExample example);

    int updateByExample(@Param("record") AdminPermissions record, @Param("example") AdminPermissionsExample example);

    int updateByPrimaryKeySelective(AdminPermissions record);

    int updateByPrimaryKey(AdminPermissions record);
}