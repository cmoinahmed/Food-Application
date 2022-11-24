package com.ty.frozenbottle.exception;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ty.frozenbottle.dto.ResponseStructure;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> hand(IdNotFoundException exception) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Not Found");
		responseStructure.setData(exception.getMessage());
		return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(InvalidEmailIdException.class)
	public ResponseEntity<ResponseStructure<String>> hand(InvalidEmailIdException exception) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Not Found");
		responseStructure.setData(exception.getMessage());
		return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(InvalidPhoneNumberException.class)
	public ResponseEntity<ResponseStructure<String>> hand(InvalidPhoneNumberException exception) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Not Found");
		responseStructure.setData(exception.getMessage());
		return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(InvalidPasswordException.class)
	public ResponseEntity<ResponseStructure<String>> hand(InvalidPasswordException exception) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Not Found");
		responseStructure.setData(exception.getMessage());
		return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);

	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		Map<String, String> info = new LinkedHashMap<String, String>();
		List<FieldError> errors = ex.getFieldErrors();
		for (FieldError error : errors) {
			String fieldName = error.getField();
			String message = error.getDefaultMessage();
			info.put(fieldName, message);
		}
		ResponseStructure<Map<String, String>> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
		responseStructure.setMessage("BAD REQUEST");
		responseStructure.setData(info);
		return new ResponseEntity<Object>(responseStructure, HttpStatus.BAD_REQUEST);
	}

}
