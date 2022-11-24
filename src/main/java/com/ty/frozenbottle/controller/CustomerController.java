package com.ty.frozenbottle.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.frozenbottle.dto.Admin;
import com.ty.frozenbottle.dto.Customer;
import com.ty.frozenbottle.dto.ResponseStructure;
import com.ty.frozenbottle.service.CustomerService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@ApiOperation(value = "save customers", notes = "input is customer obj and return same obj with id ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully saved"),
			@ApiResponse(code = 404, message = "input missing") })
	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(@RequestBody @Valid Customer customer) {
		return customerService.saveCustomer(customer);

	}

	@ApiOperation(value = "update customer", notes = "update  customer Object and return object")
	@ApiResponses(value = { @ApiResponse(code = 205, message = "Updated Sucessfully "),
			@ApiResponse(code = 404, message = "input Mismatch") })
	@PutMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Customer>> updateCustomerById(@RequestBody @Valid Customer customer) {
		return customerService.updateCustomerById(customer);

	}

	@ApiOperation(value = "Get customers by id", notes = "input is customer obj and return same obj with id ")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "arithematic exception") })
	@GetMapping(value = "/{id}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Customer>> getCustomerById(@PathVariable int id) {
		return customerService.getCustomerById(id);
	}

	@ApiOperation(value = "Get customers by email", notes = "input is customer obj and return same obj with email ")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "arithematic exception") })
	@GetMapping(value = "/{email}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Customer>> findCustomerByEmail(@PathVariable String email) {
		return customerService.findCustomerByEmail(email);

	}

	@ApiOperation(value = "Get customers by phone number", notes = "input is customer obj and return same obj with phone ")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "arithematic exception") })
	@GetMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Customer>> findCustomerByPhone(@RequestParam long phone) {
		return customerService.findCustomerByPhone(phone);
	}

	@ApiOperation(value = "validate customers by email", notes = "Input is customers Object and return object")
	@ApiResponses(value = { @ApiResponse(code = 210, message = "Customer Object validated"),
			@ApiResponse(code = 404, message = "input Mismatch") })
	@GetMapping(value = "/{email}/{password}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Customer>> validateCustomerByEmail(@PathVariable String email, String password) {
		return customerService.validateCustomerByEmail(email, password);

	}

	@ApiOperation(value = "validate customers by phone", notes = "Input is customers Object and return object")
	@ApiResponses(value = { @ApiResponse(code = 210, message = "customers Object validated"),
			@ApiResponse(code = 404, message = "input Mismatch") })
	@GetMapping(value = "/{phone}/{password}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Customer>> validateCustomerByPhone(@PathVariable long phone, String password) {
		return customerService.validateCustomerByPhone(phone, password);

	}

	@ApiOperation(value = "delete customers by id", notes = "input is customer obj and return same obj with id ")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "arithematic exception") })
	@DeleteMapping(value = "/{id}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Customer>> deleteCustomerById(@PathVariable int id) {
		return customerService.deleteCustomerById(id);
	}

}
