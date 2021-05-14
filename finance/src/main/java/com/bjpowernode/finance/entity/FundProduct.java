package com.bjpowernode.finance.entity;

import java.math.BigDecimal;

public class FundProduct {
    private Integer id;

    private Integer type;

    private Integer code;

    private String funddesc;

    private BigDecimal dailygrowth;

    private BigDecimal monthlygrowth;

    private BigDecimal annualgrowth;

    private BigDecimal leastmoney;

    private String investerm;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getFunddesc() {
        return funddesc;
    }

    public void setFunddesc(String funddesc) {
        this.funddesc = funddesc == null ? null : funddesc.trim();
    }

    public BigDecimal getDailygrowth() {
        return dailygrowth;
    }

    public void setDailygrowth(BigDecimal dailygrowth) {
        this.dailygrowth = dailygrowth;
    }

    public BigDecimal getMonthlygrowth() {
        return monthlygrowth;
    }

    public void setMonthlygrowth(BigDecimal monthlygrowth) {
        this.monthlygrowth = monthlygrowth;
    }

    public BigDecimal getAnnualgrowth() {
        return annualgrowth;
    }

    public void setAnnualgrowth(BigDecimal annualgrowth) {
        this.annualgrowth = annualgrowth;
    }

    public BigDecimal getLeastmoney() {
        return leastmoney;
    }

    public void setLeastmoney(BigDecimal leastmoney) {
        this.leastmoney = leastmoney;
    }

    public String getInvesterm() {
        return investerm;
    }

    public void setInvesterm(String investerm) {
        this.investerm = investerm == null ? null : investerm.trim();
    }
}