package com.masai.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class OrderBill {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer orderBillId;
	
	private LocalDate createdDate;
	
	private Double totalCost;
	
	@OneToOne(cascade = CascadeType.ALL)
	private SweetOrder order;
	
	// @ElementCollection
	// private List<Product> listSweetOrder = new ArrayList<>();

	
	
	
}
