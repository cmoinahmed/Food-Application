package com.ty.frozenbottle.exception;

public class InvalidPhoneNumberException extends RuntimeException {
	String message = "Enter valid PhoneNumber/Invalid Number";
	long phone;

	public InvalidPhoneNumberException(long phone, String message) {
		this.message = message;
		this.phone = phone;
	}

	public String getMessage() {
		return message;
	}

	public long getPhone() {
		return phone;
	}

}