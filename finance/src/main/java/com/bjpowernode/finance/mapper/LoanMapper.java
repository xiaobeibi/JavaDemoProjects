package com.bjpowernode.finance.mapper;

import com.bjpowernode.finance.entity.Loan;
import com.bjpowernode.finance.entity.LoanExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LoanMapper {
    long countByExample(LoanExample example);

    int deleteByExample(LoanExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Loan record);

    int insertSelective(Loan record);

    List<Loan> selectByExample(LoanExample example);

    Loan selectByPrimaryKey(Integer id);

    List<Loan> selectByExampleWithUserAndAdmin(LoanExample example);

    Loan selectByPrimaryKeyWithUserAndAdmin(Integer id);

    int updateByExampleSelective(@Param("record") Loan record, @Param("example") LoanExample example);

    int updateByExample(@Param("record") Loan record, @Param("example") LoanExample example);

    int updateByPrimaryKeySelective(Loan record);

    int updateByPrimaryKey(Loan record);
}