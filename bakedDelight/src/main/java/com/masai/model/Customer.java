package com.masai.model;


import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	private String username;
	
	private Set<SweetOrder> sweetOrders = new HashSet<>();
	
	private List<SweetItem> sweetItems = new ArrayList<>();
	
	private Cart cart;

	@Override
	public String toString() {
		return "Customer [userId=" + userId + ", username=" + username + "]";
	}

	
	
	
}
