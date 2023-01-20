package com.masai.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.masai.exception.SweetOrderException;
import com.masai.model.SweetOrder;

public class SweetOrderServiceImpl implements SweetOrderService{

	@Override
	public ResponseEntity<SweetOrder> addSweetOrder(SweetOrder sweetOrder) throws SweetOrderException {
		
		return null;
	}

	@Override
	public ResponseEntity<SweetOrder> updateSweetOrder(SweetOrder sweetOrder) throws SweetOrderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<SweetOrder> cancelSweetOrder(Integer sweetOrderId) throws SweetOrderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<List<SweetOrder>> showAllSweetOrder() throws SweetOrderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Double> calculateTotalCost(int sweetOrderId) throws SweetOrderException {
		// TODO Auto-generated method stub
		return null;
	}

}