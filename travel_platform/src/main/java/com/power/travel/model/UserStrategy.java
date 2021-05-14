package com.power.travel.model;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "user_strategy")
public class UserStrategy {

    @Id
    @Column(name = "id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "strategy_id")
    private TravelStrategy travelStrategy;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "update_date")
    private Date updateDate;

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public TravelStrategy getTravelStrategy() { return travelStrategy; }

    public void setTravelStrategy(TravelStrategy travelStrategy) { this.travelStrategy = travelStrategy; }

    public Date getCreateDate() { return createDate; }

    public void setCreateDate(Date createDate) { this.createDate = createDate; }

    public Date getUpdateDate() { return updateDate; }

    public void setUpdateDate(Date updateDate) { this.updateDate = updateDate; }
}
