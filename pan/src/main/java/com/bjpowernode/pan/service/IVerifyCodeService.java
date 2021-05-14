package com.bjpowernode.pan.service;

import com.bjpowernode.pan.dao.model.VerifyCode;

import java.util.List;

/**
 */
public interface IVerifyCodeService {
    List<VerifyCode> findVerifyCodeByCustomName(String customName);

    int modifyVerifyState(VerifyCode verifyCode);

    boolean save(VerifyCode verifyCode);

    VerifyCode findVerifyCodeByCOR(String customName, String operatePerson, String registerCode);

    boolean isValid(String registerCode);
}
