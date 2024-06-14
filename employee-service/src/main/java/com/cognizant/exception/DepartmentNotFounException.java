package com.cognizant.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class DepartmentNotFounException extends Exception {
	
	public DepartmentNotFounException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}
}
