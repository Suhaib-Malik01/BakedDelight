package com.masai.service;

import java.util.List;

import com.masai.exception.CustomerException;
import com.masai.exception.LoginException;
import com.masai.exception.ProductException;
import com.masai.model.Product;

public interface ProductService {

	
	public List<Product> viewAllProductsService() throws ProductException;
	
	public Product viewProductByIdSerivce(Integer id) throws ProductException;
	
	public Product addProductService(Product product,String key) throws ProductException, LoginException, CustomerException;
	
	public Product updateProductService(Product product,String key) throws ProductException, LoginException, CustomerException ;
	
	public List<Product> viewProductByCategoryService(String Category_name) throws ProductException;
	
	public Product removeProductService(Integer id,String key) throws ProductException, LoginException, CustomerException ;
	
}
