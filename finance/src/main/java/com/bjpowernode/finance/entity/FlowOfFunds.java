package com.bjpowernode.finance.entity;

import java.math.BigDecimal;
import java.util.Date;

public class FlowOfFunds {
    private Integer id;

    private Integer userid;

    private User user;

    private BigDecimal flowmoney;

    private Integer type;

    private String source;

    private Date createtime;

    private String funddesc;

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

    public BigDecimal getFlowmoney() {
        return flowmoney;
    }

    public void setFlowmoney(BigDecimal flowmoney) {
        this.flowmoney = flowmoney;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getFunddesc() {
        return funddesc;
    }

    public void setFunddesc(String funddesc) {
        this.funddesc = funddesc == null ? null : funddesc.trim();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}