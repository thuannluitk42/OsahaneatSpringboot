package com.thuannluit.osahaneat.repository;

import com.thuannluit.osahaneat.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer > {
}
