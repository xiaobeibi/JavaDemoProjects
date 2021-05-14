package com.power.travel.repository;

import com.power.travel.model.User;
import com.power.travel.model.TravelStrategy;
import com.power.travel.model.UserStrategy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface UserStrategyRepository extends JpaRepository<UserStrategy, String>, JpaSpecificationExecutor<UserStrategy> {

    List<UserStrategy> findUserStrategyByUser(User user);

    UserStrategy findUserStrategyByTravelStrategyAndUser(TravelStrategy travelStrategy, User user);
}
