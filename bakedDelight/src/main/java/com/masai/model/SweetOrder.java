package com.masai.model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SweetOrder {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer sweetOrderId;
	
	private User user;
	
	private List<SweetItem> listItems;
	
	private LocalDate date;
	
	private Map<Product,Integer> groupedProduct = new HashMap<>();

	@Override
	public String toString() {
		return "SweetOrder [sweetOrderId=" + sweetOrderId + ", user=" + user + ", listItems=" + listItems + ", date="
				+ date + ", groupedProduct=" + groupedProduct + "]";
	}
	
	

}
