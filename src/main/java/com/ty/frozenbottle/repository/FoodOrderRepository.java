package com.ty.frozenbottle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.frozenbottle.dto.FoodOrder;

public interface FoodOrderRepository extends JpaRepository<FoodOrder, Integer> {

}
