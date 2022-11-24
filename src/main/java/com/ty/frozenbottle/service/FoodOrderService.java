package com.ty.frozenbottle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.frozenbottle.dao.FoodOrderDao;
import com.ty.frozenbottle.dto.FoodOrder;
import com.ty.frozenbottle.dto.Item;
import com.ty.frozenbottle.dto.ResponseStructure;
import com.ty.frozenbottle.exception.IdNotFoundException;

@Service
public class FoodOrderService {
	@Autowired
	private FoodOrderDao foodOrderDao;

	public ResponseEntity<ResponseStructure<FoodOrder>> saveFoodOrder(FoodOrder foodOrder) {

		double total = 0;
		List<Item> items = foodOrder.getItems();
		for (Item item : items) {
			total = item.getCost() * item.getQuantity() + total;
			item.setFoodOrder(foodOrder);
		}
		foodOrder.setTotalCost(total);
		ResponseStructure<FoodOrder> responseStructure = new ResponseStructure<FoodOrder>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("success");
		responseStructure.setData(foodOrderDao.saveFoodOrder(foodOrder));
		return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<FoodOrder>> getFoodOrderById(int id) {
		ResponseStructure<FoodOrder> responseStructure = new ResponseStructure<FoodOrder>();
		if (foodOrderDao.getFoodOrderById(id) != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage(" SUCCESS");
			responseStructure.setData(foodOrderDao.getFoodOrderById(id));
			return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Id " + id + " Not found");
		}

	}

	public ResponseEntity<ResponseStructure<FoodOrder>> deleteFoodOrderById(int id) {
		ResponseStructure<FoodOrder> responseStructure = new ResponseStructure<FoodOrder>();
		if (foodOrderDao.deleteFoodOrderById(id)) {
			responseStructure.setStatus((HttpStatus.OK.value()));
			responseStructure.setMessage("REMOVED SUCCESSFULLY");
			responseStructure.setData(null);
			return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Id " + id + " Not found");
		}

	}

}
