package com.simplilearn.capestone.Foodbox.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Products {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	@Column
	String name;
	
	@Column
	String price;
	
	@Column
	String category;
	
	@Column
	boolean availablity;
	
	@Column
	String description;
	
	@Column
	String imageName;
	

}
