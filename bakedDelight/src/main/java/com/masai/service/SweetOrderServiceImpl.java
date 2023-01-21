 package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.masai.exception.SweetOrderException;
import com.masai.model.SweetOrder;
import com.masai.repository.SweetOrderRepository;

@Service
public class SweetOrderServiceImpl implements SweetOrderService{

	@Autowired
	private SweetOrderRepository soRepo; 
	
	@Override
	public SweetOrder addSweetOrder(SweetOrder sweetOrder) throws SweetOrderException {
		
		return soRepo.save(sweetOrder);
	}
	
	@Override
	public SweetOrder updateSweetOrder(SweetOrder sweetOrder) throws SweetOrderException {
		SweetOrder sweetOrder1= soRepo.findById(sweetOrder.getSweetOrderId()).orElseThrow(()-> new SweetOrderException("Sweet Order does not exist with Id "+sweetOrder.getSweetOrderId()));
		
		return soRepo.save(sweetOrder);
	}

	@Override
	public SweetOrder cancelSweetOrder(Integer sweetOrderId) throws SweetOrderException {
		SweetOrder sweetOrder= soRepo.findById(sweetOrderId).orElseThrow(()-> new SweetOrderException("Sweet Order does not exist with Id "+sweetOrderId));
		soRepo.delete(sweetOrder);
		return sweetOrder;
	}

	@Override
	public List<SweetOrder> showAllSweetOrder() throws SweetOrderException {
		List<SweetOrder> list= soRepo.findAll();
		if(list.size()==0) new SweetOrderException("Sweet orders not available.");
		return list;
	}

	@Override
	public Double calculateTotalCost(Integer sweetOrderId) throws SweetOrderException {
		SweetOrder sweetOrder= soRepo.findById(sweetOrderId).orElseThrow(()-> new SweetOrderException("Sweet Order does not exist with Id "+sweetOrderId));
		
		
		
		return sweetOrder.getOrderBill().getTotalCost();
	}

	

}