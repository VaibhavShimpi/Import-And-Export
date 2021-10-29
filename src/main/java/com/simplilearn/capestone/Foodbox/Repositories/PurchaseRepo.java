package com.simplilearn.capestone.Foodbox.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import com.simplilearn.capestone.Foodbox.Models.Purchase;

@Repository
public interface PurchaseRepo extends JpaRepository<Purchase, Integer>{
	
	@Query(value ="SELECT * FROM Purchase  WHERE user_id=?1",nativeQuery = true)
	List<Purchase>  findProductByUserId(int id);

}
