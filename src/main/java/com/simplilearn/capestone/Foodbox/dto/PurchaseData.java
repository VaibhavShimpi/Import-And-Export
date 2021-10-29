package com.simplilearn.capestone.Foodbox.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Component
public class PurchaseData {
	
	public String name;
	
	public String price;
	
	public int quantity;
	
	public String purchaser;
	
	public String mail;
	
	
}
