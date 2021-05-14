package com.power.travel.repository;

import com.power.travel.model.Attractions;
import com.power.travel.model.User;
import com.power.travel.model.UserAttractions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface UserAttractionsRepository extends JpaRepository<UserAttractions, String>, JpaSpecificationExecutor<UserAttractions> {

    List<UserAttractions> findUserAttractionsByUser(User user);

    UserAttractions findUserAttractionsByAttractionsAndUser(Attractions attractions, User user);
}
