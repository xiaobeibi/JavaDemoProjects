package com.bjpowernode.finance.mapper;

import com.bjpowernode.finance.entity.UserChangeMoney;
import com.bjpowernode.finance.entity.UserChangeMoneyExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserChangeMoneyMapper {

    long countByExample(UserChangeMoneyExample example);

    int deleteByExample(UserChangeMoneyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserChangeMoney record);

    int insertSelective(UserChangeMoney record);

    List<UserChangeMoney> selectByExample(UserChangeMoneyExample example);

    UserChangeMoney selectByPrimaryKey(Integer id);

    List<UserChangeMoney> selectByExampleWithUserAndChangeMoney(UserChangeMoneyExample example);

    UserChangeMoney selectByPrimaryKeyWithUserAndChangeMoney(Integer id);

    int updateByExampleSelective(@Param("record") UserChangeMoney record, @Param("example") UserChangeMoneyExample example);

    int updateByExample(@Param("record") UserChangeMoney record, @Param("example") UserChangeMoneyExample example);

    int updateByPrimaryKeySelective(UserChangeMoney record);

    int updateByPrimaryKey(UserChangeMoney record);
}