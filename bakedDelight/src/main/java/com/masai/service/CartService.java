package com.masai.service;

import com.masai.exception.ProductException;
import com.masai.model.Product;

public interface CartService {
	
	
	public Product addProductIntoCart(Integer id,String Key)throws ProductException;

}
