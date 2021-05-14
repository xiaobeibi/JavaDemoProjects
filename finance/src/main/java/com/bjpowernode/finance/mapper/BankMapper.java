package com.bjpowernode.finance.mapper;

import com.bjpowernode.finance.entity.Bank;
import com.bjpowernode.finance.entity.BankExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BankMapper {
    long countByExample(BankExample example);

    int deleteByExample(BankExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Bank record);

    int insertSelective(Bank record);

    List<Bank> selectByExample(BankExample example);

    Bank selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Bank record, @Param("example") BankExample example);

    int updateByExample(@Param("record") Bank record, @Param("example") BankExample example);

    int updateByPrimaryKeySelective(Bank record);

    int updateByPrimaryKey(Bank record);
}