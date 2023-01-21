package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CustomerException;
import com.masai.exception.LoginException;
import com.masai.exception.ProductException;
import com.masai.model.Product;
import com.masai.service.ProductService;



@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/viewall")
	public ResponseEntity<List<Product>> viewAllProductsHandler() throws ProductException{
		
		List<Product> productlist =productService.viewAllProductsService();
		
		return new ResponseEntity<List<Product>>(productlist, HttpStatus.OK);
		
	}
	
	
	@GetMapping("/viewproduct/{Id}")
	public ResponseEntity<Product> viewProductHandler(@PathVariable("Id") Integer Id) throws ProductException{
		
		Product product = productService.viewProductByIdSerivce(Id);
		
		return new ResponseEntity<Product>(product, HttpStatus.FOUND);
		
	}
	
	
	@PostMapping("/add/{key}")
	public ResponseEntity<Product> addProductHandler(@Valid @RequestBody Product product,@PathVariable("key")  String key) throws ProductException, LoginException, CustomerException {
		
		
		
		Product addedProduct = productService.addProductService(product,key);
		
		return new ResponseEntity<Product>(addedProduct, HttpStatus.ACCEPTED);
		
	}
	
	
	@PutMapping("/update/{key}")
	public ResponseEntity<Product> updateProductHandler(@Valid @RequestBody Product product,@PathVariable ("key")  String key) throws  ProductException, LoginException, CustomerException {
		
		Product updated = productService.updateProductService(product,key);
		
		return new ResponseEntity<Product>(updated, HttpStatus.OK);
	}
	
	
	@GetMapping("/viewbycategory/{category}")
	public ResponseEntity<List<Product>> viewProductByCategoryHandler(@PathVariable("category") String cname) throws ProductException{
		
		List<Product> allProducts = productService.viewProductByCategoryService(cname);
		
		return new ResponseEntity<List<Product>>(allProducts, HttpStatus.FOUND);
	}
	
	@DeleteMapping("/remove/{Id}/{key}")
	public ResponseEntity<Product> removeProductHandler(@Valid @PathVariable("Id") Integer Id,@PathVariable("key") String key) throws  ProductException, LoginException, CustomerException {
		
		Product product = productService.removeProductService(Id,key);
		
		return new ResponseEntity<Product>(product, HttpStatus.OK);
		
	}
	
	
	
}
