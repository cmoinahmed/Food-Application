package com.ty.frozenbottle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.frozenbottle.dto.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	Customer findByEmail(String email);

	Customer findByPhone(long phone);

}
