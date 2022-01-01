package com.tqi.evolution.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IllegalArgument extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public IllegalArgument(String message) {
		super(message);
	}
}
