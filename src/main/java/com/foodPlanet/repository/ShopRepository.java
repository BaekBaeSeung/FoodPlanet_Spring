package com.foodPlanet.repository;

import com.foodPlanet.entity.Member;
import com.foodPlanet.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, Long> {

}
