package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.masai.exception.OrderBillException;
import com.masai.model.OrderBill;
import com.masai.repository.OrderBillRepository;

@Service
public class OrderBillServiceImpl implements OrderBillService{

	@Autowired
	private OrderBillRepository odRepo;
	
	@Override
	public OrderBill addOrderBill(OrderBill orderBill) throws OrderBillException {
		return odRepo.save(orderBill);
		
	}

	@Override
	public OrderBill updateOrderBill(OrderBill orderBill) throws OrderBillException {
//		--------------------------------
		return null;
	}

	@Override
	public OrderBill cancelOrderBill(Integer OrderBillId) throws OrderBillException {
		OrderBill orderBill= odRepo.findById(OrderBillId).orElseThrow(new OrderBillException("Order bill does not exist with this id "+OrderBillId));
		odRepo.delete(orderBill);
		return orderBill;
	}

	@Override
	public List<OrderBill> showAllOrderBills() throws OrderBillException {
		List<OrderBill>  list = odRepo.findAll();
		if(list.size()==0) throw new OrderBillException("Order bill details not available.");
		
		return list;
	}

	@Override
	public List<OrderBill> showAllOrderBills(Integer OrderBillId) throws OrderBillException {
		List<OrderBill> list = odRepo.findAllById(OrderBillId);
		if(list.size()==0) throw new OrderBillException("Order bill details does not exist with id "+OrderBillId);
		return list;
	}
}
