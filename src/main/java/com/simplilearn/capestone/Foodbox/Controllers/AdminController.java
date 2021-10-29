package com.simplilearn.capestone.Foodbox.Controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.simplilearn.capestone.Foodbox.Models.Products;
import com.simplilearn.capestone.Foodbox.Models.Purchase;
import com.simplilearn.capestone.Foodbox.Models.RegisterUser;
import com.simplilearn.capestone.Foodbox.Services.AddProductService;
import com.simplilearn.capestone.Foodbox.Services.PurchaseService;
import com.simplilearn.capestone.Foodbox.Services.RegisterUserService;
import com.simplilearn.capestone.Foodbox.dto.PurchaseData;


@Controller
public class AdminController {
	
	public static String uploadDir = System.getProperty("user.dir")+"/src/main/resources/static/productImages";

	
	@Autowired
	AddProductService addProductService;
	
	@Autowired
	RegisterUserService registerUserService;
	
	@Autowired
	PurchaseService purchaseService;
	
	
	
	@GetMapping("/admin/home")
	public ModelAndView getAdminPage(@SessionAttribute("user") RegisterUser user) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", user);
		mv.setViewName("adminHome");
		return mv;
	}
	
	@GetMapping("/admin/userData")
	public ModelAndView getUserData(@SessionAttribute("user") RegisterUser user) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", user);
		mv.addObject("users", registerUserService.getAllUsers());
		mv.setViewName("userData");
		return mv;
	}
	
	@GetMapping("/admin/products")
    public ModelAndView getProductData(@SessionAttribute("user") RegisterUser user){
        ModelAndView mv = new ModelAndView();
        mv.addObject("products",addProductService.getAllProducts());
        mv.addObject("user", user);
        mv.setViewName("products");
        return mv;

    }
	
	@GetMapping("/admin/products/add")
	public ModelAndView addProductsPage(@SessionAttribute("user") RegisterUser user){
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", user);
        mv.addObject("product", new Products());
        mv.setViewName("productsAdd");

        return mv;
		
	}
	@PostMapping("/admin/products/add")
	public String addProductData(@ModelAttribute Products product, @RequestParam("productImage")MultipartFile multipartFile, @RequestParam("imageName") String imageName) throws IOException {

        String imageUUID;

        if(!multipartFile.isEmpty()){

            imageUUID = multipartFile.getOriginalFilename();

            Path filenameAndPath = Paths.get(uploadDir,imageUUID);
            Files.write(filenameAndPath,multipartFile.getBytes());

        }else{

            imageUUID = imageName;
        }
        product.setAvailablity(true);
        product.setImageName(imageUUID);
        addProductService.saveProduct(product);
        return "redirect:/admin/products";

    }
	
	@GetMapping("/admin/purchaseData")
	public ModelAndView purchaseData(@SessionAttribute("user") RegisterUser user) {
		
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
		mv.addObject("purchases", purchaseData);
		mv.setViewName("purchaseReport");
		return mv;
	}
	
	/*@GetMapping("/admin/home")
	public String adminHome() {
		
		return "adminProfile";
	}*/

}
