package com.masai.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
public class OrderBill {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer orderBillId;
	
	private LocalDate createdDate;
	
	private Double totalCost;
	
	private List<SweetOrder> listSweetOrder = new ArrayList<>();

	@Override
	public String toString() {
		return "OrderBill [orderBillId=" + orderBillId + ", createdDate=" + createdDate + ", totalCost=" + totalCost
				+ ", listSweetOrder=" + listSweetOrder + "]";
	}
	
	
}
