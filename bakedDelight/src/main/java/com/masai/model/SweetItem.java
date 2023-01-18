package com.masai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class SweetItem {
	
	
//	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer orderItemId;
	
	private Product product;
	
	private Integer quat;
	
	@Override
	public String toString() {
		return "SweetItem [orderItemId=" + orderItemId + ", product=" + product + "]";
	}
	
	
	

}
