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

@Entity
public class SweetOrder {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer sweetOrderId;
	
	private LocalDate date;

	@OneToOne(cascade = CascadeType.ALL,mappedBy = "order")
	private OrderBill orderBill;

	@OneToOne(cascade = CascadeType.ALL)
	private Cart cart;

	@Override
	public String toString() {
		return "SweetOrder [sweetOrderId=" + sweetOrderId + ", date=" + date + ", orderBill=" + orderBill + ", cart="
				+ cart + "]";
	}


	
	
	
}
