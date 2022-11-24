package com.ty.frozenbottle.exception;

public class IdNotFoundException extends RuntimeException {
	private String message = "Given Id is not Found";

	public IdNotFoundException() {

	}

	public IdNotFoundException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
