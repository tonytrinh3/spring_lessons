package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//i think we are creating an AOP to catch all responses between front end to database for the whole project

@ControllerAdvice
//maybe in section 61 for exception handling
//which allows to handle exceptions across the whole application in one global handling component
//https://zetcode.com/springboot/controlleradvice/
//It declares @ExceptionHandler, @InitBinder, or @ModelAttribute methods to be shared across multiple @Controller classes.
public class CustomerRestExceptionHandler {
	
	// add an exception handler for customernotfoundexception 
	
	//why do you need this
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException exc){
		
		//create CustomerErrorResponse
		
		CustomerErrorResponse error = new CustomerErrorResponse(HttpStatus.NOT_FOUND.value(),exc.getMessage(),System.currentTimeMillis());
			
		//return ResponseEntity
		
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	//add another exception handler ... to catch any exception (catch all)
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(Exception exc){ //exception is catch all
		
		//create CustomerErrorResponse
		
		CustomerErrorResponse error = new CustomerErrorResponse(HttpStatus.BAD_REQUEST.value(),exc.getMessage(),System.currentTimeMillis());
		
		
		//return ResponseEntity
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
}
