package com.ty.frozenbottle.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ty.frozenbottle.dto.FoodOrder;
import com.ty.frozenbottle.repository.FoodOrderRepository;

@Repository
public class FoodOrderDao {
	@Autowired
	private FoodOrderRepository foodOrderRepository;

	public FoodOrder saveFoodOrder(FoodOrder foodOrder) {
		return foodOrderRepository.save(foodOrder);
	}

	public List<FoodOrder> getAllFoodOrder() {
		return foodOrderRepository.findAll();
	}

	public FoodOrder getFoodOrderById(int id) {
		Optional<FoodOrder> optional = foodOrderRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}

	}

	public boolean deleteFoodOrderById(int id) {
		Optional<FoodOrder> optional = foodOrderRepository.findById(id);
		if (optional.isPresent()) {
			foodOrderRepository.delete(optional.get());
			return true;
		} else {
			return false;
		}
	}

}
