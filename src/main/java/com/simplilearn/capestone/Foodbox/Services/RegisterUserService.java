package com.simplilearn.capestone.Foodbox.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.capestone.Foodbox.Models.RegisterUser;
import com.simplilearn.capestone.Foodbox.Repositories.RegisterUserRepo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegisterUserService {
	
	@Autowired
	RegisterUserRepo registerUserRepo;
	
	public boolean saveUser(RegisterUser user) {
		
		try{
			
			registerUserRepo.save(user);
			
		}catch (IllegalArgumentException e) {
			
			return false;
		}
		
		return true;
	}
	
	public RegisterUser searchUser(String email) {
		
		RegisterUser registerUser = registerUserRepo.findByEmail(email);
		return registerUser;
		
		
	}

	public List<RegisterUser> getAllUsers() {
	
		return registerUserRepo.findAll();
	}
	
	public RegisterUser findUserById(int id) {
		
		return registerUserRepo.findById(id).orElse(new RegisterUser());
	}

}
