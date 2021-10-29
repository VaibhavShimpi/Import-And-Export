package com.simplilearn.capestone.Foodbox.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.capestone.Foodbox.Models.RegisterUser;

@Repository
public interface RegisterUserRepo extends JpaRepository<RegisterUser, Integer>{
	
	

	RegisterUser findByEmail(String email);

}
