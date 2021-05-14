package com.bjpowernode.finance.service.impl;

import com.bjpowernode.finance.entity.Info;
import com.bjpowernode.finance.entity.InfoExample;
import com.bjpowernode.finance.mapper.InfoMapper;
import com.bjpowernode.finance.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InfoServiceImpl implements InfoService {
    @Autowired
    InfoMapper infoMapper;


    @Override
    public List<Info> selectInfoOrderByUserIdDesc(Integer receiveid) {
        InfoExample infoExample = new InfoExample();
        infoExample.createCriteria().andReceiveidEqualTo(receiveid);
        infoExample.setOrderByClause("i.id desc");
        return infoMapper.selectByExampleWithUserAndAdmin(infoExample);
    }

    @Override
    public Info selectInfoById(Integer id) {
        return infoMapper.selectByPrimaryKeyWithUserAndAdmin(id);
    }

    @Override
    @Transactional
    public Integer insertInfo(Info info) {
        return infoMapper.insertSelective(info);
    }

    @Override
    @Transactional
    public Integer updateInfo(Info info) {
        return infoMapper.updateByPrimaryKeySelective(info);
    }

    @Override
    @Transactional
    public Integer deleteInfobyId(Integer id) {
        return infoMapper.deleteByPrimaryKey(id);
    }
}
