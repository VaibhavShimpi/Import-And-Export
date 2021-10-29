package com.simplilearn.capestone.Foodbox.ExceptionHandling;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHelper {
	
	@ExceptionHandler
	public final ResponseEntity<ErrorMessage> itemNotFound(NotFoundException nfe){
		
		ErrorMessage errorResponse = new ErrorMessage("item not found","the item for which you have requested is not available in database"); 
		return new ResponseEntity<ErrorMessage>(errorResponse,new HttpHeaders(),HttpStatus.NOT_FOUND);
	}

}
