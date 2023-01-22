package com.masai.service;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.masai.exception.OrderBillException;
import com.masai.model.OrderBill;
import com.masai.model.SweetOrder;
import com.masai.repository.OrderBillRepository;
import com.masai.repository.SweetOrderRepository;

@Service
public class OrderBillServiceImpl implements OrderBillService{

	@Autowired
	private OrderBillRepository odRepo;
	
	@Autowired
	private SweetOrderRepository sweetOrderrepo;
	
	
	
	
	
	
	
	@Override
	public OrderBill addOrderBill(Integer sweetOrderId) throws OrderBillException {
		Optional<SweetOrder>  opt =  sweetOrderrepo.findById(sweetOrderId);
		if(opt.isEmpty())throw new OrderBillException("Please check sweetOrderId: "+sweetOrderId);
		SweetOrder order =	opt.get();
		
		OrderBill bill = new OrderBill();
		bill.setCreatedDate(LocalDate.now());
		bill.setOrder(order);
		bill.setTotalCost(order.getTotalCost());
		
		
		return odRepo.save(bill) ;
	}



	@Override
	public OrderBill showOrderBills(Integer OrderBillId) throws OrderBillException {
		return odRepo.findById(OrderBillId).orElseThrow(()-> new OrderBillException("Order bill does not exist with the id "+ OrderBillId));
	}




	
	
}
