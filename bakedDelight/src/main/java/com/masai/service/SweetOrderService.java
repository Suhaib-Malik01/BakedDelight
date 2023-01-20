package com.masai.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.masai.exception.SweetOrderException;
import com.masai.model.SweetOrder;

public interface SweetOrderService {
	public ResponseEntity<SweetOrder> addSweetOrder(SweetOrder sweetOrder) throws SweetOrderException;
	
	public ResponseEntity<SweetOrder> updateSweetOrder(SweetOrder sweetOrder) throws SweetOrderException;
	
	public ResponseEntity<SweetOrder> cancelSweetOrder(Integer sweetOrderId) throws SweetOrderException;
	
	public ResponseEntity<List<SweetOrder>> showAllSweetOrder() throws SweetOrderException;
	
	public ResponseEntity<Double> calculateTotalCost(int sweetOrderId) throws SweetOrderException;
}