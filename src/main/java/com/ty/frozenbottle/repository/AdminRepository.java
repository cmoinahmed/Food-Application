package com.ty.frozenbottle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.frozenbottle.dto.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

	Admin findByEmail(String email);

	Admin findByPhone(long phone);
}
