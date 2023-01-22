package com.masai.model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SweetOrder {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer sweetOrderId;
	
	private LocalDate date;

	@OneToOne(cascade = CascadeType.ALL,mappedBy = "order")
	private OrderBill orderBill;
	
	@OneToOne
	private Cart cart;

	private Double totalCost;


	
	
	
}
