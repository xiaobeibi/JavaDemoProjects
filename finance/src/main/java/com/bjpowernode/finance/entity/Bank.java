package com.bjpowernode.finance.entity;

public class Bank {
    private Integer id;

    private String name;

    private String type;

    private String assets;

    private String bankdesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getAssets() {
        return assets;
    }

    public void setAssets(String assets) {
        this.assets = assets == null ? null : assets.trim();
    }

    public String getBankdesc() {
        return bankdesc;
    }

    public void setBankdesc(String bankdesc) {
        this.bankdesc = bankdesc == null ? null : bankdesc.trim();
    }
}