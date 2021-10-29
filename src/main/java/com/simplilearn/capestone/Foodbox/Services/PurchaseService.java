package com.simplilearn.capestone.Foodbox.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.capestone.Foodbox.Models.Purchase;
import com.simplilearn.capestone.Foodbox.Repositories.PurchaseRepo;

@Service
public class PurchaseService {
	
	@Autowired
	PurchaseRepo purchaseRepo;
	
	public void savePurchaseData(Purchase purchase) {
		
		purchaseRepo.save(purchase);
	}

	public List<Purchase> findAllPurchaseData() {
		// TODO Auto-generated method stub
		return purchaseRepo.findAll();
	}

	public List<Purchase> findProductByUserId(int id) {
		// TODO Auto-generated method stub
		return purchaseRepo.findProductByUserId(id);
	}

}
