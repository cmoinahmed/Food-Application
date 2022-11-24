package com.ty.frozenbottle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.frozenbottle.dao.FoodMenuDao;
import com.ty.frozenbottle.dto.FoodMenu;
import com.ty.frozenbottle.dto.Product;
import com.ty.frozenbottle.dto.ResponseStructure;
import com.ty.frozenbottle.exception.IdNotFoundException;

@Service
public class FoodMenuService {

	@Autowired
	private FoodMenuDao foodMenuDao;

	public ResponseEntity<ResponseStructure<FoodMenu>> saveFoodMenu(FoodMenu foodMenu) {
		ResponseStructure<FoodMenu> responseStructure = new ResponseStructure<FoodMenu>();
		List<Product> products = foodMenu.getProduct();
		for (Product product : products) {
			product.setMenu(foodMenu);
		}
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Created");
		responseStructure.setData(foodMenuDao.saveFoodMenu(foodMenu));

		return new ResponseEntity<ResponseStructure<FoodMenu>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<FoodMenu>> getProductById(int id) {
		FoodMenu foodMenu = foodMenuDao.getProductById(id);
		ResponseStructure<FoodMenu> responseStructure = new ResponseStructure<FoodMenu>();
		if (foodMenu != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(foodMenuDao.getProductById(id));
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Id not found:" + id);
		}

	}

	public ResponseEntity<ResponseStructure<FoodMenu>> deleteProductById(int id) {
		ResponseStructure<FoodMenu> responseStructure = new ResponseStructure<FoodMenu>();
		if (foodMenuDao.deleteProductById(id)) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(null);
		}
		throw new IdNotFoundException("Id not found:" + id);
	}

}
