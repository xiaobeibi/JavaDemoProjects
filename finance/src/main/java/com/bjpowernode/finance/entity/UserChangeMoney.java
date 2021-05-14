package com.bjpowernode.finance.entity;

import java.math.BigDecimal;
import java.util.Date;

public class UserChangeMoney {
    private Integer id;

    private Integer userid;

    private User user;

    private Integer changeid;

    private ChangeMoney changeMoney;

    private Date starttime;

    private BigDecimal averyield;

    private BigDecimal profit;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getChangeid() {
        return changeid;
    }

    public void setChangeid(Integer changeid) {
        this.changeid = changeid;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public BigDecimal getAveryield() {
        return averyield;
    }

    public void setAveryield(BigDecimal averyield) {
        this.averyield = averyield;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ChangeMoney getChangeMoney() {
        return changeMoney;
    }

    public void setChangeMoney(ChangeMoney changeMoney) {
        this.changeMoney = changeMoney;
    }
}