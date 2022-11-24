package com.ty.frozenbottle.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.frozenbottle.dto.FoodOrder;
import com.ty.frozenbottle.dto.ResponseStructure;
import com.ty.frozenbottle.service.FoodOrderService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController

@RequestMapping("/foodorders")
public class FoodOrderController {
	@Autowired
	private FoodOrderService foodOrderService;

	@ApiOperation(value = "save foodorder", notes = "input is foodorder obj and return same obj with foodorder ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully saved"),
			@ApiResponse(code = 404, message = "input missing") })
	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<FoodOrder>> saveFoodOrder(@RequestBody FoodOrder foodOrder) {
		return foodOrderService.saveFoodOrder(foodOrder);

	}

	@ApiOperation(value = "Get foodorder by id", notes = "input is foodorder obj and return same obj with id ")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "arithematic exception") })
	@GetMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<FoodOrder>> getFoodOrderById(@RequestParam int id) {
		return foodOrderService.getFoodOrderById(id);
	}

	@ApiOperation(value = "delete foodorder by id", notes = "input is foodorder obj and return same obj with id ")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "arithematic exception") })
	@DeleteMapping(value = "/{id}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<FoodOrder>> deleteFoodOrderById(@PathVariable int id) {
		return foodOrderService.deleteFoodOrderById(id);
	}
}
