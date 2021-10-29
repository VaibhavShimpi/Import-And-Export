package com.simplilearn.capestone.Foodbox.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.capestone.Foodbox.Models.Products;
import com.simplilearn.capestone.Foodbox.Repositories.ProductRepo;


@Service
public class AddProductService {
	
	@Autowired
	ProductRepo productRepo;

	public void saveProduct(Products product) {
		
		productRepo.save(product);
		
	}

	public List<Products> getAllProducts() {
		
		return productRepo.findAll();
	}
	
	public List<Products> getAllProductsByCategories(String category){
		
		return productRepo.findAllByCategory(category);
	}
	
	public List<Products> findProductsWithName(String keyWord){
		
		return productRepo.findByKeyWord(keyWord);
	}

	public Products findProductById(Integer id) {
		
		return productRepo.findById(id).orElse(new Products());
		
	}

	public Products findProductByName(String products) {
		// TODO Auto-generated method stub
		return productRepo.findProductByName(products);
	}

}
