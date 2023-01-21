package com.masai.service;

import java.util.List;

import com.masai.Dto.ProductDto;
import com.masai.exception.CartException;
import com.masai.exception.CustomerException;
import com.masai.exception.ProductException;
import com.masai.model.Cart;
import com.masai.model.Product;

public interface CartService {

	public Product addProductIntoCart(Integer id, String Key, Integer quantity)throws ProductException, CustomerException;

	public Cart removeProduct(Integer cartId, Integer prodId) throws ProductException, CartException;

	public Cart updateProductQuantity(Integer cartId, Integer prodId, Integer quantity) throws CartException, ProductException;

	public Cart removeAllProduct(Integer cartId) throws CartException;

	public List<ProductDto> viewAllProduct(Integer cartId) throws CartException;


}
