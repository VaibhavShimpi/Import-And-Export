package com.simplilearn.capestone.Foodbox.Models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Purchase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	
	@Column
	public String products;
	
	
	@ManyToOne
	@JoinColumn(name="user_id")
	public RegisterUser user;
	

}
