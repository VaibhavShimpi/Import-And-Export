package com.simplilearn.capestone.Foodbox.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.simplilearn.capestone.Foodbox.Models.RegisterUser;
import com.simplilearn.capestone.Foodbox.Services.RegisterUserService;

@Controller
public class SignUpController {

	@Autowired
	RegisterUserService registerUserService;
	
	@GetMapping("/")
    public String showHomePage(){
        return "index";
    }
	
	@GetMapping("/register")
    public ModelAndView showRegisterPage(){

        ModelAndView mv = new ModelAndView();
        mv.addObject("user",new RegisterUser());
        mv.setViewName("signUp");
        return mv;

    }
	
	@PostMapping("/register")
    public String showLogin(@ModelAttribute("user") RegisterUser user){
		user.setRole("User");
		
        boolean result = registerUserService.saveUser(user);
        return "login";
    }
}
