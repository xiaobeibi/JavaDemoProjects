package com.bjpowernode.finance.service;


import com.bjpowernode.finance.entity.UserPayMoney;

import java.util.List;

public interface UserPayMoneyService {

    Integer insertUserPayMoney(UserPayMoney userPayMoney);

    List<UserPayMoney> selectUserPayMoneyByUserId(Integer userId);

    Integer updateUserPayMoney(UserPayMoney userPayMoney);

    UserPayMoney selectUserPayMoneyById(Integer id);
}
