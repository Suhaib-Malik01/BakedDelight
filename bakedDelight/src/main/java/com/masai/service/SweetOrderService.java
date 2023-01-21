package com.masai.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.masai.exception.SweetOrderException;
import com.masai.model.SweetOrder;

public interface SweetOrderService {
	public SweetOrder addSweetOrder(SweetOrder sweetOrder) throws SweetOrderException;
	
	public SweetOrder updateSweetOrder(SweetOrder sweetOrder) throws SweetOrderException;
	
	public SweetOrder cancelSweetOrder(Integer sweetOrderId) throws SweetOrderException;
	
	public List<SweetOrder> showAllSweetOrder() throws SweetOrderException;
	
	public Double calculateTotalCost(Integer sweetOrderId) throws SweetOrderException;
}