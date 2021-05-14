package com.ecjtu.service.impl;

import com.ecjtu.entity.Admin;
import com.ecjtu.mapper.AdminMapper;
import com.ecjtu.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public int addAdmin(Admin admin) {
        int i = adminMapper.addAdmin(admin);
        return i;
    }

    @Override
    public int deleteAdmin(Integer id) {
        int i = adminMapper.deleteAdmin(id);
        return i;
    }

    @Override
    public int updateAdmin(Admin admin) {
        int i = adminMapper.updateAdmin(admin);
        return i;
    }

    @Override
    public List<Admin> getAdmins() {
        List<Admin> admins = adminMapper.getAdmins();
        return admins;
    }

    @Override
    public Admin findById(Integer id) {
        Admin admin = adminMapper.findById(id);
        return admin;
    }

    @Override
    public Admin loginAdmin(Admin admin) {
        Admin admin1 = adminMapper.loginAdmin(admin);
        return admin1;
    }

    @Override
    public List<Admin> findByName(String adminName) {
        List<Admin> byName = adminMapper.findByName(adminName);
        return byName;
    }

    @Override
    public void deleteBatch(List<Integer> ids) {
        adminMapper.deleteBatch(ids);
    }


}
