package com.simplilearn.capestone.Foodbox.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.simplilearn.capestone.Foodbox.Models.Products;
import com.simplilearn.capestone.Foodbox.Models.RegisterUser;
import com.simplilearn.capestone.Foodbox.Repositories.ProductRepo;
import com.simplilearn.capestone.Foodbox.Services.AddProductService;

import javassist.NotFoundException;


@Controller
public class CartController {
	
	@Autowired
	AddProductService addProductService;
	
	
	@GetMapping("/shop/addToCart/{id}")
	public ModelAndView addToCart(@SessionAttribute("user") RegisterUser user,@PathVariable("id") Integer id) throws NotFoundException {
		ModelAndView mv = new ModelAndView();
		mv.addObject("user",user);
		Products products = addProductService.findProductById(id);
		if(products.getName()=="")
			throw new NotFoundException("Product Not available");
		
		mv.addObject("cart", products);
		mv.setViewName("cart");
		
		return mv;
	}
	
	@GetMapping("/checkout/{id}")
    public ModelAndView addTOCheckout(@SessionAttribute("user") RegisterUser user,@PathVariable("id")Integer id){

        Products product = addProductService.findProductById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("user",user);
        mv.addObject("cart",product);
        mv.setViewName("checkout");
        return mv;
    }

}
