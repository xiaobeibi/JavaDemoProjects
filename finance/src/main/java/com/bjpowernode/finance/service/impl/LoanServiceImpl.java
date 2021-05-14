package com.bjpowernode.finance.service.impl;

import com.bjpowernode.finance.entity.Loan;
import com.bjpowernode.finance.entity.LoanExample;
import com.bjpowernode.finance.mapper.LoanMapper;
import com.bjpowernode.finance.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    LoanMapper loanMapper;

    @Override
    @Transactional
    public Integer insertLoan(Loan loan) {
        return loanMapper.insertSelective(loan);
    }

    @Override
    public List<Loan> selectLoanByLoanId(Integer loanId) {
        LoanExample loanExample = new LoanExample();
        loanExample.createCriteria().andLoanidEqualTo(loanId);
        return loanMapper.selectByExampleWithUserAndAdmin(loanExample);
    }

    @Override
    public List<Loan> selectAllLoanByApplyStatusAsc() {
        LoanExample loanExample = new LoanExample();
        loanExample.setOrderByClause("applyStatus asc");
        return loanMapper.selectByExampleWithUserAndAdmin(loanExample);
    }

    @Override
    public List<Loan> selectAllExamedLoan() {
        LoanExample loanExample = new LoanExample();
        loanExample.createCriteria().andApplystatusEqualTo(2);
        return loanMapper.selectByExampleWithUserAndAdmin(loanExample);
    }

    @Override
    public Loan selectLoanById(Integer id) {
        return loanMapper.selectByPrimaryKeyWithUserAndAdmin(id);
    }

    @Override
    @Transactional
    public Integer updateLoan(Loan loan) {
        return loanMapper.updateByPrimaryKeySelective(loan);
    }
}
