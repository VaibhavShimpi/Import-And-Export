package com.simplilearn.capestone.Foodbox.Controllers;


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.simplilearn.capestone.Foodbox.Models.RegisterUser;
import com.simplilearn.capestone.Foodbox.Services.AddProductService;
import com.simplilearn.capestone.Foodbox.Services.RegisterUserService;

@Controller
@SessionAttributes("user")
public class LoginController {
	
	@Autowired
	RegisterUserService registerUserService;
	
	@Autowired
	AddProductService addProductService;

	@GetMapping("/login")
    public String showLoginPage(){
		
        return "login";
    }
	
	@PostMapping("/login")
	public ModelAndView showEntryPage(@ModelAttribute("user")RegisterUser user,@RequestParam String email, @RequestParam String password){
		ModelAndView mv = new ModelAndView();
		RegisterUser registerUser =  registerUserService.searchUser(user.getEmail());
		String pass = registerUser.getPassword();
		if(pass.equalsIgnoreCase(user.getPassword())) {
			
			String role = registerUser.getRole();

			if(role.equalsIgnoreCase("Admin")) {
				mv.addObject("user", registerUser);
				mv.setViewName("adminHome");
				return mv;
			}else  {
				
				mv.addObject("user", registerUser);
				mv.addObject("products", addProductService.getAllProducts());
				mv.setViewName("shop");
				return mv;
				
			}
		}else {
			mv.addObject("user", registerUser);
			mv.setViewName("redirect:/login");
			return mv;
			
		}
	}
	
	
	@ModelAttribute("user")
	 public RegisterUser shoppingCart() {
	  return new RegisterUser();
	 }
	
	@GetMapping("/logout")
	public String logoutPage() {
		
		return "login";
	}
	

}	
