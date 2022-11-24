package com.ty.frozenbottle.dao;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.frozenbottle.dto.Admin;
import com.ty.frozenbottle.dto.Customer;
import com.ty.frozenbottle.repository.CustomerRepository;

@Repository
public class CustomerDao {

	@Autowired
	private CustomerRepository customerRepository;

	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	public Customer updateAdminById(Customer customer) {
		return customerRepository.save(customer);
	}

	public Customer getCustomerById(int id) {
		Optional<Customer> optional = customerRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	public Customer findCustomerByEmail(String email) {
		Customer customer = customerRepository.findByEmail(email);
		if (customer != null) {
			return customer;
		} else {
			return null;
		}

	}

	public Customer findCustomerByPhone(long phone) {
		Customer customer = customerRepository.findByPhone(phone);
		if (customer != null) {
			return customer;
		} else {
			return null;
		}
	}

	public Customer validateAdminByEmail(String email) {
		return customerRepository.findByEmail(email);
	}

	public Customer validateAdminByPhone(long phone) {
		return customerRepository.findByPhone(phone);
	}

	public boolean deleteCustomerById(int id) {
		Optional<Customer> optional = customerRepository.findById(id);
		if (optional.isPresent()) {
			customerRepository.delete(optional.get());
			return true;
		} else {
			return false;
		}
	}

}