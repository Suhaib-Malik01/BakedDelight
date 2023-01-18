package com.masai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SweetItem {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer orderItemId;
	
	private Product product;
	
	private SweetOrder sweetOrder;

	@Override
	public String toString() {
		return "SweetItem [orderItemId=" + orderItemId + ", product=" + product + "]";
	}
	
	
	

}
