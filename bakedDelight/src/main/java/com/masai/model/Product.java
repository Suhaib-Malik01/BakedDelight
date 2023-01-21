package com.masai.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productID;

	@NotNull
	@Size(min = 3, max = 20)
	private String name;

	@NotNull
	@Size(min = 3, max = 35)
	private String photoPath;

	@NotNull
	@Min(100)
	private Double price;

	@NotNull
	private String description;

	@NotNull
	private Boolean available;

	@NotNull
	@Min(0)
	private Integer quantity;

	@ManyToOne(cascade = CascadeType.ALL)
	private Category category;

}
