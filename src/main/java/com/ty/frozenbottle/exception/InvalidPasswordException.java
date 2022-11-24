package com.ty.frozenbottle.exception;

public class InvalidPasswordException extends RuntimeException {
	String message = "Invalid password ";

	public InvalidPasswordException() {

	}

	public InvalidPasswordException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
