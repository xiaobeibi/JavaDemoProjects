package com.power.travel.repository;

import com.power.travel.model.User;
import com.power.travel.model.Hotel;
import com.power.travel.model.UserHotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserHotelRepository extends JpaRepository<UserHotel, String>, JpaSpecificationExecutor<UserHotel> {
    List<UserHotel> findUserHotelsByUser(User user);

    UserHotel findUserHotelByHotelAndUser(Hotel hotel, User user);

}
