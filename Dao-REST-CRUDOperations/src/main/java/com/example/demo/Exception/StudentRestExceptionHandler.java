package com.example.demo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException (StudentNotFoundException sfe) {
		
		StudentErrorResponse response = new StudentErrorResponse();
		response.setStatus(HttpStatus.NOT_FOUND.value());
		response.setMessage(sfe.getMessage());
		response.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<StudentErrorResponse>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException (Exception e) {
		
		StudentErrorResponse response = new StudentErrorResponse();
		response.setStatus(HttpStatus.BAD_REQUEST.value());
		response.setMessage(e.getMessage());
		response.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<StudentErrorResponse>( response, HttpStatus.BAD_REQUEST);
	}
}
