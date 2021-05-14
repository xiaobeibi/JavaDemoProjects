package com.bjpowernode.finance.service.impl;

import com.bjpowernode.finance.entity.UserPayMoney;
import com.bjpowernode.finance.entity.UserPayMoneyExample;
import com.bjpowernode.finance.mapper.UserPayMoneyMapper;
import com.bjpowernode.finance.service.UserPayMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserPayMoneyServiceImpl implements UserPayMoneyService {

    @Autowired
    UserPayMoneyMapper userPayMoneyMapper;

    @Override
    @Transactional
    public Integer insertUserPayMoney(UserPayMoney userPayMoney) {
        return userPayMoneyMapper.insertSelective(userPayMoney);
    }

    @Override
    public List<UserPayMoney> selectUserPayMoneyByUserId(Integer userId) {
        UserPayMoneyExample upme = new UserPayMoneyExample();
        upme.createCriteria().andUseridEqualTo(userId);
        return userPayMoneyMapper.selectByExampleWithUserAndPayMoney(upme);
    }

    @Override
    @Transactional
    public Integer updateUserPayMoney(UserPayMoney userPayMoney) {
        return userPayMoneyMapper.updateByPrimaryKeySelective(userPayMoney);
    }

    @Override
    public UserPayMoney selectUserPayMoneyById(Integer id) {
        return userPayMoneyMapper.selectByPrimaryKeyWithUserAndPayMoney(id);
    }
}
