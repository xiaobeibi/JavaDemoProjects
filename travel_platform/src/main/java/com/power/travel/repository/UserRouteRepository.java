package com.power.travel.repository;

import com.power.travel.model.TravelRoute;
import com.power.travel.model.User;
import com.power.travel.model.UserRoute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRouteRepository extends JpaRepository<UserRoute, String>, JpaSpecificationExecutor<UserRoute> {

    List<UserRoute> findUserRouteByUser(User user);

    UserRoute findUserRouteByTravelRouteAndUser(TravelRoute travelRoute, User user);
}
