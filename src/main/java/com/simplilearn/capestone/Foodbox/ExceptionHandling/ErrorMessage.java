package com.simplilearn.capestone.Foodbox.ExceptionHandling;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Component
public class ErrorMessage{
	
	public String message;
	public String details;

}
