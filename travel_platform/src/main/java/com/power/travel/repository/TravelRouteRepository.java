package com.power.travel.repository;

import com.power.travel.model.TravelRoute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TravelRouteRepository extends JpaRepository<TravelRoute, String>, JpaSpecificationExecutor<TravelRoute> {
}
