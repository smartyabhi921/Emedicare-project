package com.boot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException 

{
     @ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponce> resourceNotFoundException(ResourceNotFoundException ex)
	{
    	
         String message = ex.getMessage();
    	 
    	 ApiResponce response = new ApiResponce();
    	 response.setMessage(message);
    	 response.setStatus(false);
    	 
    	 return new ResponseEntity<ApiResponce>(response,HttpStatus.NOT_FOUND);
    	 
	}
	
}
