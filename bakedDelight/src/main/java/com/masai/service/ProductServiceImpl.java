package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CustomerException;
import com.masai.exception.LoginException;
import com.masai.exception.ProductException;
import com.masai.model.Category;
import com.masai.model.CurrentUserSession;
import com.masai.model.Product;
import com.masai.repository.CategoryRepository;
import com.masai.repository.CustomerRepository;
import com.masai.repository.ProductRepository;
import com.masai.repository.SessionRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	public ProductRepository productRepo;

	@Autowired
	public SessionRepository sessionRepo;
	
	@Autowired
	public CategoryRepository cRepo;

	@Autowired
	public CustomerRepository customerRepo;

	@Override
	public List<Product> viewAllProductsService() throws ProductException {

		List<Product> productlist = productRepo.findAll();

		if (productlist.isEmpty()) {
			throw new ProductException("Products not available to show...");
		}
		return productlist;
	}

	@Override
	public Product viewProductByIdSerivce(Integer id) throws ProductException {
		Optional<Product> opt = productRepo.findById(id);
		if (opt.isEmpty()) {
			throw new ProductException("Product not found with productId: " + id);
		}

		Product product = opt.get();
		return product;
	}

	@Override
	public Product addProductService(Product product, String key)throws ProductException, LoginException, CustomerException {

		//security check......
		CurrentUserSession status =	sessionRepo.findByUuid(key);
		
        if(status==null) {
			
			throw new LoginException("Customer not logged yet..plz login first");
			
		}
		
		if(status.getRole().equalsIgnoreCase("customer")) {
			
			throw new CustomerException("You are not authorized to add products");
			
		}
		
		
		
		List<Category> categories = cRepo.findAll();
		
		for(Category ele: categories) {
			if(product.getCategory().getName().equalsIgnoreCase(ele.getName()))
			{
				product.setCategory(ele);
				ele.getProducts().add(product);
			}

		}
		
		
		Product addedproduct = productRepo.save(product);

		return addedproduct;
	}

	@Override
	public Product updateProductService(Product product, String key) throws ProductException, CustomerException, LoginException {
		
		//security check......
				CurrentUserSession status =	sessionRepo.findByUuid(key);
				
		        if(status==null) {
					
					throw new LoginException("Customer not logged yet..plz login first");
					
				}
				
				if(status.getRole().equalsIgnoreCase("customer")) {
					
					throw new CustomerException("You are not authorized to update products");
					
				}
		   
		
		Optional<Product> pro = productRepo.findById(product.getProductID());

		if (pro.isPresent()) {
			
			
			List<Category> categories = cRepo.findAll();
			
			for(Category ele: categories) {
				if(product.getCategory().getName().equalsIgnoreCase(ele.getName()))
				{
					product.setCategory(ele);
					ele.getProducts().add(product);
				}

			}

			return productRepo.save(product);

		}

		throw new ProductException("product not found with the Id: " + product.getProductID());

	}

	@Override
	public List<Product> viewProductByCategoryService(String Category_name) throws ProductException {
		
        // List<Product> products = productRepo.findByCategory(Category_name);
		List<Category> categories = cRepo.findAll();
		
		for(Category ele: categories) {
			if(ele.getName().equalsIgnoreCase(Category_name)) {
				return ele.getProducts();
			}
		}
	        
		
		throw new ProductException("Product not found");
		         
		                    
		
	}

	@Override
	public Product removeProductService(Integer id, String key) throws ProductException, CustomerException, LoginException {
		
		//security check......
		CurrentUserSession status =	sessionRepo.findByUuid(key);
		
        if(status==null) {
			
			throw new LoginException("Customer not logged yet..plz login first");
			
		}
		
		if(status.getRole().equalsIgnoreCase("customer")) {
			
			throw new CustomerException("You are not authorized to remove products");
			
		}
		                       
                Optional<Product> opt = productRepo.findById(id);
                
                Category storecat = opt.get().getCategory();
		
		          if(opt.isPresent()) {
		        	  
			           opt.get().setCategory(null);
		        	  productRepo.delete(opt.get());
			 
		        	  opt.get().setCategory(storecat);
			          return opt.get();
			
		            }
		
		throw new ProductException("Product not found with the id :"+id);
		
	}

}
