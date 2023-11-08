package com.cg.trg.boot.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.trg.boot.dto.AppResponse;
import com.cg.trg.boot.exceptions.DuplicateEmployeeException;
import com.cg.trg.boot.exceptions.EmployeeNotFoundException;

@ControllerAdvice
public class AppErrorHandler {
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<AppResponse> handleNotFound(EmployeeNotFoundException ex) {
		return new ResponseEntity<AppResponse>(ex.getResponse(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(DuplicateEmployeeException.class)
	public ResponseEntity<AppResponse> handleNotFound(DuplicateEmployeeException ex) {
		return new ResponseEntity<AppResponse>(ex.getResponse(), HttpStatus.BAD_REQUEST);
	}
}
