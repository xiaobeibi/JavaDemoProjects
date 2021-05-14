package com.power.travel.repository;

import com.power.travel.model.TravelStrategy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TravelStrategyRepository extends JpaRepository<TravelStrategy, String>, JpaSpecificationExecutor<TravelStrategy> {



}
