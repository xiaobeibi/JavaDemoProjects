package com.power.travel.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_route")
public class UserRoute {
    @Id
    @Column(name = "id")
    private String id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "route_id")
    private TravelRoute travelRoute;

    @Column(name = "create_date")
    private Date createDate;

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public Date getCreateDate() { return createDate; }

    public void setCreateDate(Date createDate) { this.createDate = createDate; }

    public TravelRoute getTravelRoute() { return travelRoute; }

    public void setTravelRoute(TravelRoute travelRoute) { this.travelRoute = travelRoute; }
}
