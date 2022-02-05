package com.sjp.practice.util;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CEAdvice {
	
	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<?> handleEmptyIn(EmptyInputException e){
		return new ResponseEntity<String>("Empty input", HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<?> handleEmptyIn(EntityNotFoundException e){
		return new ResponseEntity<String>("Details not found in DB", HttpStatus.BAD_REQUEST);
	}
}
