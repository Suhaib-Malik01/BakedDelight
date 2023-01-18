package com.masai.model;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class Cart {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer cartId;
	
//	@ElementCollection
//	private Map<Product,Integer> listProduct = new HashMap<>();
	
	private Integer productCount;
	
	private Double cartTotal;
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "cart")
	@JoinColumn(name = "CustomerID")
	private Customer customer;

	@OneToOne(mappedBy = "cart")
	private SweetOrder sweetOrder;
	
	
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId
				+ ", productCount=" + productCount + ", total=" + cartTotal + "]";
	}
	
	
	
	
}
