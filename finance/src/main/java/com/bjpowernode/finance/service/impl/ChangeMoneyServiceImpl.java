package com.bjpowernode.finance.service.impl;

import com.bjpowernode.finance.entity.ChangeMoney;
import com.bjpowernode.finance.mapper.ChangeMoneyMapper;
import com.bjpowernode.finance.service.ChangeMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ChangeMoneyServiceImpl implements ChangeMoneyService {

    @Autowired
    ChangeMoneyMapper changeMoneyMapper;

    @Override
    public List<ChangeMoney> selectAllChangeMoney() {
        List<ChangeMoney> list = changeMoneyMapper.selectByExample(null);
        return list;
    }

    @Override
    public ChangeMoney selectChangeMoneyById(Integer id) {
        ChangeMoney changeMoney = changeMoneyMapper.selectByPrimaryKey(id);
        return changeMoney;
    }

    @Override
    @Transactional
    public Integer insertChangeMoney(ChangeMoney changeMoney) {
        return changeMoneyMapper.insertSelective(changeMoney);
    }

    @Override
    @Transactional
    public Integer updateChangeMoney(ChangeMoney changeMoney) {
        return changeMoneyMapper.updateByPrimaryKeySelective(changeMoney);
    }

    @Override
    @Transactional
    public Integer deleteChangeMoneyById(Integer id) {
        return changeMoneyMapper.deleteByPrimaryKey(id);
    }
}
