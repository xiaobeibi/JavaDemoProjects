package com.bjpowernode.finance.service;

import com.bjpowernode.finance.entity.Bank;

import java.util.List;

public interface BankService {

    List<Bank> selectAllBank();

    Bank selectBankById(Integer id);

    Integer insertBank(Bank bank);

    Integer updateBank(Bank bank);

    Integer deleteBankById(Integer id);
}
