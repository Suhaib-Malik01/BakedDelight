package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.masai.exception.ProductException;
import com.masai.model.CurrentUserSession;
import com.masai.model.Product;
import com.masai.repository.ProductRepository;

public class CartServiceImpl implements CartService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CurrentUserSession currentUserSession;
	
	
	

	@Override
	public Product addProductIntoCart(Integer id, String Key) throws ProductException {
		
		   String kString=currentUserSession.getUuid();
		   Optional<Product> productOpt;
		   if(kString.equals(Key)) {
			   
			 productOpt=   productRepository.findById(id);
			
			
			
		   }
		
		
		              
		
		   return null;
		
		
	}
	
	

	

}
