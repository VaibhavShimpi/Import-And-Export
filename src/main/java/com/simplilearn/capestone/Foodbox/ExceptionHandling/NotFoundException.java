package com.simplilearn.capestone.Foodbox.ExceptionHandling;

public class NotFoundException extends RuntimeException{
	
	NotFoundException(String messege){
		
		super(messege);
	}

}
