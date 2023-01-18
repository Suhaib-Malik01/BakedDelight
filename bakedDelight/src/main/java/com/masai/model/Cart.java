package com.masai.model;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cart {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer cartId;
	
	private Double grandTotal;
	
	private List<Product> listProduct = new ArrayList<>();
	
	private Integer productCount;
	
	private Double total;

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", grandTotal=" + grandTotal + ", listProduct=" + listProduct
				+ ", productCount=" + productCount + ", total=" + total + "]";
	}
	
	
	
	
}
