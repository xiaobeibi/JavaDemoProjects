package com.bjpowernode.finance.service.impl;

import com.bjpowernode.finance.entity.Admin;
import com.bjpowernode.finance.entity.AdminExample;
import com.bjpowernode.finance.mapper.AdminMapper;
import com.bjpowernode.finance.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired(required = false)
    AdminMapper adminMapper;

    @Override
    public Admin selectAdminByTerms(String username, String password) {
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        if (username!=null){
            criteria.andUsernameEqualTo(username);
        }
        if (password!=null){
            criteria.andPasswordEqualTo(password);
        }
        List<Admin> list = adminMapper.selectByExample(adminExample);
        if ("[]".equals(list.toString())){
            return null;
        }else {
            return list.get(0);
        }
    }

    @Override
    @Transactional
    public Integer updateAdmin(Admin admin) {
        int result = adminMapper.updateByPrimaryKeySelective(admin);
        return result;
    }

    @Override
    public Admin selectAdminById(Integer id) {
        Admin admin = adminMapper.selectByPrimaryKey(id);
        return admin;
    }
}
