package com.masai.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

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
	
	@OneToOne
	private Product product;
	
	private Integer quantity;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Cart cart;
	
	
	
	
	

}
