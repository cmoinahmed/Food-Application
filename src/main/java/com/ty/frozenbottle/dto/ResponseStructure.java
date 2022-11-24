package com.ty.frozenbottle.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponseStructure<T> {
	private int status;
	private String message;
	private T data;
}
