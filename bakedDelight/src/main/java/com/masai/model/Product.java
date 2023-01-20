package com.masai.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer productID;
	
	private String name;
	
	private String photoPath;
	
	private Double price;
	
	private String description;
	
	private Boolean available;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Category category;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "product")
	private SweetItem sweetitem;

}
