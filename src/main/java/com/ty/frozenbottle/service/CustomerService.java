package com.ty.frozenbottle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.frozenbottle.dao.CustomerDao;
import com.ty.frozenbottle.dto.Admin;
import com.ty.frozenbottle.dto.Customer;
import com.ty.frozenbottle.dto.ResponseStructure;
import com.ty.frozenbottle.exception.IdNotFoundException;
import com.ty.frozenbottle.exception.InvalidEmailIdException;
import com.ty.frozenbottle.exception.InvalidPasswordException;
import com.ty.frozenbottle.exception.InvalidPhoneNumberException;

@Service
public class CustomerService {
	@Autowired
	private CustomerDao customerDao;

	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(Customer customer) {
		ResponseStructure<Customer> responseStructure = new ResponseStructure<Customer>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Created");
		responseStructure.setData(customerDao.saveCustomer(customer));
		return new ResponseEntity<>(responseStructure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<Customer>> getCustomerById(int id) {
		Customer customer = customerDao.getCustomerById(id);
		ResponseStructure<Customer> responseStructure = new ResponseStructure<Customer>();
		if (customer != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(customerDao.getCustomerById(id));
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Id not found:" + id);
		}
	}

	public ResponseEntity<ResponseStructure<Customer>> findCustomerByEmail(String email) {
		Customer customer = customerDao.findCustomerByEmail(email);
		ResponseStructure<Customer> responseStructure = new ResponseStructure<Customer>();
		if (customer != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(customerDao.findCustomerByEmail(email));
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {

			throw new InvalidEmailIdException("Invalid Email " + email);
		}

	}

	public ResponseEntity<ResponseStructure<Customer>> findCustomerByPhone(long phone) {
		Customer customer = customerDao.findCustomerByPhone(phone);
		ResponseStructure<Customer> responseStructure = new ResponseStructure<Customer>();
		if (customer != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(customerDao.findCustomerByPhone(phone));
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {
			throw new InvalidPhoneNumberException(phone, "Please enter valid Phone_number");
		}
	}

	public ResponseEntity<ResponseStructure<Customer>> validateCustomerByEmail(String email, String password) {
		ResponseStructure<Customer> responseStructure = new ResponseStructure<Customer>();
		Customer customer = customerDao.findCustomerByEmail(email);
		if (customer != null) {
			if (customer.getPassword().equals(password)) {
				responseStructure.setStatus(HttpStatus.OK.value());
				responseStructure.setMessage("success");
				responseStructure.setData(customer);
				return new ResponseEntity<>(responseStructure, HttpStatus.OK);
			} else {
				throw new InvalidPasswordException("Invalid password : " + password);
			}
		} else {
			throw new InvalidEmailIdException("Please enter valid email id: " + email);
		}

	}

	public ResponseEntity<ResponseStructure<Customer>> validateCustomerByPhone(long phone, String password) {
		ResponseStructure<Customer> responseStructure = new ResponseStructure<Customer>();
		Customer customer = customerDao.findCustomerByPhone(phone);
		if (customer != null) {
			if (customer.getPassword().equals(password)) {
				responseStructure.setStatus(HttpStatus.OK.value());
				responseStructure.setMessage("success");
				responseStructure.setData(customer);
				return new ResponseEntity<>(responseStructure, HttpStatus.OK);
			} else {
				throw new InvalidPasswordException("Invalid password : " + password);
			}
		} else {
			throw new InvalidPhoneNumberException(phone, "Please enter valid Phone_number");
		}

	}

	public ResponseEntity<ResponseStructure<Customer>> updateCustomerById(Customer customer) {
		ResponseStructure<Customer> responseStructure = new ResponseStructure<Customer>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("success");
		responseStructure.setData(customerDao.saveCustomer(customer));
		return new ResponseEntity<>(responseStructure, HttpStatus.OK);

	}

	public ResponseEntity<ResponseStructure<Customer>> deleteCustomerById(int id) {
		ResponseStructure<Customer> responseStructure = new ResponseStructure<Customer>();
		if (customerDao.deleteCustomerById(id)) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(null);
		}
		throw new IdNotFoundException("Id not found:" + id);
	}
}
