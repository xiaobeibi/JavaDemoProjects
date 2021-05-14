package com.bjpowernode.finance.service;

import com.bjpowernode.finance.entity.UserChangeMoney;

import java.util.List;

public interface UserChangeMoneyService {

    Integer insertUserChangeMoney(UserChangeMoney userChangeMoney);

    List<UserChangeMoney> selectUserChangeMoneyByUserId(Integer userId);

    Integer updateUserChangeMoney(UserChangeMoney userChangeMoney);

    UserChangeMoney selectUserChangeMoneyById(Integer id);
}
