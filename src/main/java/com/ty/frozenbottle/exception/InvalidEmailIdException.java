package com.ty.frozenbottle.exception;

public class InvalidEmailIdException extends RuntimeException {
	String message = "Invalid Email Id/Enter valid Email";

	public InvalidEmailIdException() {

	}

	public InvalidEmailIdException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
