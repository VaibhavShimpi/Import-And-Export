package com.simplilearn.capestone.Foodbox.Repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.simplilearn.capestone.Foodbox.Models.Products;

@Repository
public interface ProductRepo extends JpaRepository<Products, Integer>{

	List<Products> findAllByCategory(String category);

	
	@Query(value ="SELECT * FROM Products  WHERE name LIKE %?1% OR category LIKE %?1% OR description LIKE %?1%",nativeQuery = true)
	List<Products> findByKeyWord(String keyword);


	Products findProductByName(String products);


	



}
