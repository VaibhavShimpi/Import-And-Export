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

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class RegisterUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	@Column
	String firstName;
	
	@Column
	String lastName;
	
	@Column
	String email;
	
	@Column
	String role;
	
	@Column
	String password;
	
	

}
