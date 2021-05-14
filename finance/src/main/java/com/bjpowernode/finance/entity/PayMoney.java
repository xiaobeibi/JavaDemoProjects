package com.bjpowernode.finance.entity;

import java.math.BigDecimal;

public class PayMoney {
    private Integer id;

    private BigDecimal monthmoney;

    private Integer autointo;

    private Integer type;

    private String investerm;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getMonthmoney() {
        return monthmoney;
    }

    public void setMonthmoney(BigDecimal monthmoney) {
        this.monthmoney = monthmoney;
    }

    public Integer getAutointo() {
        return autointo;
    }

    public void setAutointo(Integer autointo) {
        this.autointo = autointo;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getInvesterm() {
        return investerm;
    }

    public void setInvesterm(String investerm) {
        this.investerm = investerm == null ? null : investerm.trim();
    }
}