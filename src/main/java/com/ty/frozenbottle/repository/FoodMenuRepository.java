package com.ty.frozenbottle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.frozenbottle.dto.FoodMenu;

public interface FoodMenuRepository extends JpaRepository<FoodMenu, Integer> {
}
