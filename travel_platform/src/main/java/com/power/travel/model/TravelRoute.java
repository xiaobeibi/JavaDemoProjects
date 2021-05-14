package com.power.travel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "travel_route")
public class TravelRoute {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "routeName")
    private String name;

    @Column(name = "routeDescribe")
    private String describe;

    @Column(name = "routeAddress")
    private String address;

    @Column(name = "routeStatus")
    private Integer status;

    @Column(name = "collect_number")
    private Integer collectNumber;

    @Column(name = "createDate")
    private Date createDate;

    @Column(name = "update_date")
    private Date updateDate;

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDescribe() { return describe; }

    public void setDescribe(String describe) { this.describe = describe; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public Integer getStatus() { return status; }

    public void setStatus(Integer status) { this.status = status; }

    public Integer getCollectNumber() { return collectNumber; }

    public void setCollectNumber(Integer collectNumber) { this.collectNumber = collectNumber; }

    public Date getCreateDate() { return createDate; }

    public void setCreateDate(Date createDate) { this.createDate = createDate; }

    public Date getUpdateDate() { return updateDate; }

    public void setUpdateDate(Date updateDate) { this.updateDate = updateDate; }
}
