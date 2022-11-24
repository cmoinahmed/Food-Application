package com.ty.frozenbottle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.frozenbottle.dao.AdminDao;
import com.ty.frozenbottle.dto.Admin;
import com.ty.frozenbottle.dto.Customer;
import com.ty.frozenbottle.dto.ResponseStructure;
import com.ty.frozenbottle.exception.IdNotFoundException;
import com.ty.frozenbottle.exception.InvalidEmailIdException;
import com.ty.frozenbottle.exception.InvalidPasswordException;
import com.ty.frozenbottle.exception.InvalidPhoneNumberException;

@Service
public class AdminService {
	@Autowired
	private AdminDao adminDao;

	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin admin) {
		ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Created");
		responseStructure.setData(adminDao.saveAdmin(admin));
		return new ResponseEntity<>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Admin>> getAdminById(int id) {
		ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();
		Admin admin = adminDao.getAdminById(id);
		if (admin != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(adminDao.getAdminById(id));
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Id not found:" + id);
		}
	}

	public ResponseEntity<ResponseStructure<Admin>> updateAdminById(Admin admin) {
		ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("success");
		responseStructure.setData(adminDao.saveAdmin(admin));
		return new ResponseEntity<>(responseStructure, HttpStatus.OK);

	}

	public ResponseEntity<ResponseStructure<Admin>> findAdminByEmail(String email) {
		Admin admin = adminDao.findAdminByEmail(email);
		ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();
		if (admin != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(adminDao.findAdminByEmail(email));
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {

			throw new InvalidEmailIdException("Invalid Email " + email);
		}

	}

	public ResponseEntity<ResponseStructure<Admin>> findAdminByPhone(long phone) {
		Admin admin = adminDao.findAdminByPhone(phone);
		ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();
		if (admin != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(adminDao.findAdminByPhone(phone));
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {
			throw new InvalidPhoneNumberException(phone, "Please enter valid Phone_number");
		}
	}

	public ResponseEntity<ResponseStructure<Admin>> validateAdminByEmail(String email, String password) {
		ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();
		Admin admin = adminDao.findAdminByEmail(email);
		if (admin != null) {
			if (admin.getPassword().equals(password)) {
				responseStructure.setStatus(HttpStatus.OK.value());
				responseStructure.setMessage("success");
				responseStructure.setData(admin);
				return new ResponseEntity<>(responseStructure, HttpStatus.OK);
			} else {
				throw new InvalidPasswordException("Invalid password : " + password);
			}
		} else {
			throw new InvalidEmailIdException("Please enter valid email id: " + email);
		}

	}

	public ResponseEntity<ResponseStructure<Admin>> validateAdminByPhone(long phone, String password) {
		ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();
		Admin admin = adminDao.findAdminByPhone(phone);
		if (admin != null) {
			if (admin.getPassword().equals(password)) {
				responseStructure.setStatus(HttpStatus.OK.value());
				responseStructure.setMessage("success");
				responseStructure.setData(admin);
				return new ResponseEntity<>(responseStructure, HttpStatus.OK);
			} else {
				throw new InvalidPasswordException("Invalid password : " + password);
			}
		} else {
			throw new InvalidPhoneNumberException(phone, "Please enter valid Phone_number");
		}

	}

	public ResponseEntity<ResponseStructure<Admin>> deleteAdminById(int id) {
		ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();
		if (adminDao.deleteAdminById(id)) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(null);
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		}
		throw new IdNotFoundException("Id not found:" + id);

	}

}
