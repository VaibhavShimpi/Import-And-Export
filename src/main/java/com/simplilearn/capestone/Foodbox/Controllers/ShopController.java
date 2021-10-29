package com.simplilearn.capestone.Foodbox.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.simplilearn.capestone.Foodbox.Models.Products;
import com.simplilearn.capestone.Foodbox.Models.Purchase;
import com.simplilearn.capestone.Foodbox.Models.RegisterUser;
import com.simplilearn.capestone.Foodbox.Services.AddProductService;
import com.simplilearn.capestone.Foodbox.Services.PurchaseService;
import com.simplilearn.capestone.Foodbox.Services.RegisterUserService;


@Controller
public class ShopController {
	
	@Autowired
	AddProductService addProductService;
	
	@Autowired
	RegisterUserService registerUserService;
	
	@Autowired
	PurchaseService purchaseService;
	
	
	@GetMapping("/breakfast")
	public ModelAndView getAllBreakfast(@SessionAttribute("user") RegisterUser user){
		
		ModelAndView mv =new ModelAndView();
		
		List<Products> breakfast = addProductService.getAllProductsByCategories("breakfast");
		mv.addObject("products", breakfast);
		mv.addObject("user", user);
		mv.setViewName("shop");
		return mv; 
		
		
	}
	
	@GetMapping("/lunch")
	public ModelAndView getAllLunch(@SessionAttribute("user") RegisterUser user){
		
	
		ModelAndView mv =new ModelAndView();
		
		List<Products> lunch = addProductService.getAllProductsByCategories("lunch");
		
		mv.addObject("products", lunch);
		mv.addObject("user", user);
		mv.setViewName("shop");
		return mv;
		
		
	}
	
	@GetMapping("/bevarages")
	public ModelAndView getAllBevarages(@SessionAttribute("user") RegisterUser user){
		
		
		ModelAndView mv =new ModelAndView();
		
		List<Products> bevarages =addProductService.getAllProductsByCategories("bevarages");
		mv.addObject("products", bevarages);
		mv.addObject("user", user);
		mv.setViewName("shop");
		
		return mv;
		
		
	}
	
	@GetMapping("/deserts")
	public ModelAndView getAllDeserts(@SessionAttribute("user") RegisterUser user){
		
		

		ModelAndView mv =new ModelAndView();
		
		List<Products> deserts =addProductService.getAllProductsByCategories("deserts");
		
		mv.addObject("products", deserts);
		mv.addObject("user", user);
		mv.setViewName("shop");
		
		return mv;
		
		
	}
	@GetMapping("/streetfood")
	public ModelAndView getAllStreetFood(@SessionAttribute("user") RegisterUser user){
		
		

		ModelAndView mv =new ModelAndView();
		
		List<Products> streetFood =addProductService.getAllProductsByCategories("Street Food");
		
		mv.addObject("products", streetFood);
		mv.addObject("user", user);
		mv.setViewName("shop");
		
		return mv;
		
		
	}
	
	@PostMapping("/search/food")
	public ModelAndView findFoodByName(@SessionAttribute("user") RegisterUser user,@RequestParam String food) {
		
		ModelAndView mv =new ModelAndView();
		mv.addObject("user", user);
		List<Products> foods =addProductService.findProductsWithName(food);
		
		mv.addObject("products", foods);
		mv.setViewName("shop");
		
		return mv;
	}
	
	@GetMapping("/shop")
	public ModelAndView shopPage(@SessionAttribute("user") RegisterUser user) {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", user);
		mv.addObject("products", addProductService.getAllProducts());
		mv.setViewName("shop");
		
		return mv;
	}
	
	@GetMapping("/orders")
	public ModelAndView ordersPage(@SessionAttribute("user") RegisterUser user) {
		
		List<Purchase> purchaseList = purchaseService.findProductByUserId(user.getId());
		List<Products> products = new ArrayList<Products>();
		for(Purchase purchase:purchaseList) {
			
			products.add(addProductService.findProductByName(purchase.getProducts()));
			
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", user);
		mv.addObject("products", products);
		mv.setViewName("orders");
		
		return mv;
	}
	
	@GetMapping("/profile")
	public ModelAndView profilePage(@SessionAttribute("user") RegisterUser user) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", user);
		mv.setViewName("profile");
		return mv;
	}
	

}
