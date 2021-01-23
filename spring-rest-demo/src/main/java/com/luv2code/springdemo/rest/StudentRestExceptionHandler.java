package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
//this controlleradvice is special...for soem reason to AOP
//for global exception handling
public class StudentRestExceptionHandler {
	
	//add exception handling code here 
	
	//add an exception handler using @ExceptionHandler
	
		@ExceptionHandler
		public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
			
			//create a StudentErrorResponse
			
			StudentErrorResponse error = new StudentErrorResponse();
			
			error.setStatus(HttpStatus.NOT_FOUND.value()); //not found is 404
			error.setMessage(exc.getMessage());
			error.setTimeStamp(System.currentTimeMillis()); //it is type long
			
			//return ResponseEntity
			
			return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
		}
		
		
		// add another exception handler ... to catch any exception (catch all)
		
		@ExceptionHandler
		public ResponseEntity<StudentErrorResponse> handleException (Exception exc){
			
			
			//create a StudentErrorResponse
			
			StudentErrorResponse error = new StudentErrorResponse();
			
			error.setStatus(HttpStatus.BAD_REQUEST.value()); //bad request is 400
			error.setMessage(exc.getMessage()); //this is the message that you see 
			error.setTimeStamp(System.currentTimeMillis()); //it is type long
			
			//return ResponseEntity
			
			return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
		}
		

}
