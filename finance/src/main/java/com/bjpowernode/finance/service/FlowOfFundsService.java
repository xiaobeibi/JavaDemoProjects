package com.bjpowernode.finance.service;

import com.bjpowernode.finance.entity.FlowOfFunds;

import java.util.List;

public interface FlowOfFundsService {

    Integer insertFlowOfFunds(FlowOfFunds flowOfFunds);

    List<FlowOfFunds> selectFlowOfFundsByUserId(Integer userId);
}
