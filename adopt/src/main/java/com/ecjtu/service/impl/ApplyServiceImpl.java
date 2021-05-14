package com.ecjtu.service.impl;

import com.ecjtu.entity.Apply;
import com.ecjtu.mapper.ApplyMapper;
import com.ecjtu.service.ApplyService;
import com.ecjtu.util.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.List;

/**
 */
@Service
public class ApplyServiceImpl implements ApplyService {

    @Autowired
    private ApplyMapper applyMapper;


    @Override
    public int addApply(Apply apply) {
        String email="2425549281@qq.com";
        try {
            MailUtil.sendMail(email,apply.getState());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        int i = applyMapper.addApply(apply);
        return i;
    }

    @Override
    public int updateApply(Apply apply) {
        int i = applyMapper.updateApply(apply);
        return i;
    }

    @Override
    public int deleteApply(Integer id) {
        int i = applyMapper.deleteApply(id);
        return i;
    }

    @Override
    public List<Apply> getApply() {
        List<Apply> apply = applyMapper.getApply();
        return apply;
    }

    @Override
    public Apply findById(Integer id) {
        Apply byId = applyMapper.findById(id);
        return byId;
    }

    @Override
    public List<Apply> findByState(Integer state) {
        List<Apply> byState = applyMapper.findByState(state);
        return byState;
    }

    @Override
    public void deleteBatch(List<Integer> ids) {
        applyMapper.deleteBatch(ids);
    }
}
