package com.bjpowernode.pan.dao.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 */
@Entity
@Table(name = "linkSecret")
public class LinkSecret {
    @Id
    @GeneratedValue
    private int id;

    private String fileName;

    private String userName;

    private String localLink;

    private Date expireDate;

    private String secret;

    // 下载次数
    private int downloadNum;

    private String secretLink;

    // 分享时间
    private Date shareDate;

    public Date getShareDate() {
        return shareDate;
    }

    public void setShareDate(Date shareDate) {
        this.shareDate = shareDate;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLocalLink() {
        return localLink;
    }

    public void setLocalLink(String localLink) {
        this.localLink = localLink;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public int getDownloadNum() {
        return downloadNum;
    }

    public void setDownloadNum(int downloadNum) {
        this.downloadNum = downloadNum;
    }

    public String getSecretLink() {
        return secretLink;
    }

    public void setSecretLink(String secretLink) {
        this.secretLink = secretLink;
    }
}
