package com.ty.frozenbottle.dao;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ty.frozenbottle.dto.Admin;
import com.ty.frozenbottle.dto.Customer;
import com.ty.frozenbottle.repository.AdminRepository;

@Repository
public class AdminDao {
	@Autowired
	private AdminRepository adminRepository;

	public Admin saveAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

	public Admin getAdminById(int id) {
		Optional<Admin> optional = adminRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	public Admin findAdminByEmail(String email) {
		Admin admin = adminRepository.findByEmail(email);
		if (admin != null) {
			return admin;
		} else {
			return null;
		}

	}

	public Admin findAdminByPhone(long phone) {
		Admin admin = adminRepository.findByPhone(phone);
		if (admin != null) {
			return admin;
		} else {
			return null;
		}
	}

	public Admin validateAdminByEmail(String email) {
		return adminRepository.findByEmail(email);
	}

	public Admin validateAdminByPhone(long phone) {
		return adminRepository.findByPhone(phone);
	}

	public Admin updateAdminById(Admin admin) {
		return adminRepository.save(admin);
	}

	public boolean deleteAdminById(int id) {
		Optional<Admin> optional = adminRepository.findById(id);
		if (optional.isPresent()) {
			adminRepository.delete(optional.get());
			return true;
		} else {
			return false;
		}
	}
}
