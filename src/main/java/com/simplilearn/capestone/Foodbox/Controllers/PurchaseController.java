package com.simplilearn.capestone.Foodbox.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.simplilearn.capestone.Foodbox.Models.Products;
import com.simplilearn.capestone.Foodbox.Models.Purchase;
import com.simplilearn.capestone.Foodbox.Models.RegisterUser;
import com.simplilearn.capestone.Foodbox.Services.AddProductService;
import com.simplilearn.capestone.Foodbox.Services.PurchaseService;
import com.simplilearn.capestone.Foodbox.Services.RegisterUserService;
import com.simplilearn.capestone.Foodbox.dto.PurchaseData;


@Controller
public class PurchaseController {
	
	@Autowired
	AddProductService addProductService;
	
	@Autowired
	RegisterUserService registerUserService;
	
	@Autowired
	PurchaseService purchaseService;
	
	
	@PostMapping("/payNow/{id}")
	public ModelAndView orderPlaced(@SessionAttribute("user") RegisterUser user,@PathVariable("id") Integer id) {
		
		ModelAndView mv = new ModelAndView();
		List<Purchase> purchase = purchaseService.findAllPurchaseData();
		
		List<PurchaseData> purchaseData = new ArrayList<PurchaseData>();
		
		for(Purchase data:purchase) {
			
			PurchaseData purchaseDummy =  new PurchaseData();
			Products prod = addProductService.findProductByName(data.getProducts());
			RegisterUser registerUser = data.getUser();
			
			purchaseDummy.setName(prod.getName());
			purchaseDummy.setPrice(prod.getPrice());
			purchaseDummy.setQuantity(1);
			purchaseDummy.setPurchaser(registerUser.getFirstName());
			purchaseDummy.setMail(registerUser.getEmail());
			purchaseData.add(purchaseDummy);
			
		}
		
		
		mv.addObject("user", user);
		mv.addObject("products", purchaseData);
		mv.setViewName("orderPlaced");
		return mv;
	}

}
