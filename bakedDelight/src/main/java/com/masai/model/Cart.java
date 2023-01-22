package com.masai.model;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.masai.Dto.ProductDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
	@JsonIgnore
	private Customer customer;

	@OneToOne(cascade = CascadeType.ALL,mappedBy = "cart")    
	@JsonIgnore
	private SweetOrder sweetOrder;
	
	@ElementCollection
	@JsonIgnore
	private Map<Product, Integer> productList = new HashMap<>();
}
