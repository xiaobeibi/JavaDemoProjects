package com.bjpowernode.finance.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Loan {
    private Integer id;

    private Integer loanid;

    private User user;

    private Integer examineid;

    private Admin admin;

    private Date loantime;

    private BigDecimal amount;

    private Integer term;

    private BigDecimal rate;

    private Integer applystatus;

    private Integer loanstatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLoanid() {
        return loanid;
    }

    public void setLoanid(Integer loanid) {
        this.loanid = loanid;
    }

    public Integer getExamineid() {
        return examineid;
    }

    public void setExamineid(Integer examineid) {
        this.examineid = examineid;
    }

    public Date getLoantime() {
        return loantime;
    }

    public void setLoantime(Date loantime) {
        this.loantime = loantime;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Integer getApplystatus() {
        return applystatus;
    }

    public void setApplystatus(Integer applystatus) {
        this.applystatus = applystatus;
    }

    public Integer getLoanstatus() {
        return loanstatus;
    }

    public void setLoanstatus(Integer loanstatus) {
        this.loanstatus = loanstatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}