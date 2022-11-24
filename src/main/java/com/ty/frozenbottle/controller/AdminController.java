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
import com.ty.frozenbottle.service.AdminService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;

	@ApiOperation(value = "save admin", notes = "Input is Admin Object and return object")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Sucessfully Saved"),
			@ApiResponse(code = 404, message = "input Mismatch") })
	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(@RequestBody @Valid Admin admin) {
		return adminService.saveAdmin(admin);
	}

	@ApiOperation(value = "update admin", notes = "update  Admin Object and return object")
	@ApiResponses(value = { @ApiResponse(code = 205, message = "Updated Sucessfully "),
			@ApiResponse(code = 404, message = "input Mismatch") })
	@PutMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Admin>> updateAdminById(@RequestBody @Valid Admin admin) {
		return adminService.updateAdminById(admin);

	}

	@ApiOperation(value = "Get admin by id", notes = "input is admin obj and return same obj with id ")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "arithematic exception") })
	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Admin>> getAdminById(@PathVariable int id) {
		return adminService.getAdminById(id);
	}

	@ApiOperation(value = "Get admin by email", notes = "input is admin obj and return same obj with email ")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "arithematic exception") })
	@GetMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Admin>> findAdminByEmail(@RequestParam String email) {
		return adminService.findAdminByEmail(email);

	}

	@ApiOperation(value = "Get admin by phone number", notes = "input is customer obj and return same obj with phone ")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "arithematic exception") })
	@GetMapping(value = "/phone/{phone}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Admin>> findAdminByPhone(@PathVariable long phone) {
		return adminService.findAdminByPhone(phone);
	}

	@ApiOperation(value = "validate admin by email", notes = "Input is Admin Object and return object")
	@ApiResponses(value = { @ApiResponse(code = 210, message = "Admin Object validated"),
			@ApiResponse(code = 404, message = "input Mismatch") })
	@GetMapping(value = "/email/{email}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Admin>> validateAdminByEmail(@PathVariable String email,
			@RequestParam String password) {
		return adminService.validateAdminByEmail(email, password);

	}

	@ApiOperation(value = "validate admin by phone", notes = "Input is Admin Object and return object")
	@ApiResponses(value = { @ApiResponse(code = 210, message = "Admin Object validated"),
			@ApiResponse(code = 404, message = "input Mismatch") })
	@GetMapping(value = "/{phone}/{password}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Admin>> validateAdminByPhone(@PathVariable long phone,
			@PathVariable String password) {
		return adminService.validateAdminByPhone(phone, password);

	}

	@ApiOperation(value = "delete admin by id", notes = "input is admin obj and return same obj with id ")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "arithematic exception") })
	@DeleteMapping(value = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Admin>> deleteAdminById(@PathVariable int id) {
		return adminService.deleteAdminById(id);
	}

}
