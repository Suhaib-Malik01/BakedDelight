package com.masai.service;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.masai.exception.CustomerException;
import com.masai.exception.LoginException;
import com.masai.exception.OrderBillException;
import com.masai.model.CurrentUserSession;
import com.masai.model.Customer;
import com.masai.model.OrderBill;
import com.masai.repository.CartRepository;
import com.masai.repository.CustomerRepository;
import com.masai.repository.OrderBillRepository;
import com.masai.repository.SessionRepository;

@Service
public class OrderBillServiceImpl implements OrderBillService{

	@Autowired
	private OrderBillRepository odRepo;
	@Autowired
	private SessionRepository sessionRepository;
	
	@Autowired
	private CustomerRepository cRepo;
	
	
	@Override
	public OrderBill addOrderBill(OrderBill orderBill, String key) throws OrderBillException, LoginException, CustomerException {
		
		orderBill.setCreatedDate(LocalDate.now());
		CurrentUserSession status = sessionRepository.findByUuid(key);
		if(status==null) {
			throw new LoginException("Please Login first ...");
		}
		if(status.getRole().equalsIgnoreCase("customer")) {
			Customer customer= cRepo.findById(status.getUserId()).orElseThrow(()->new LoginException("User is not register..."));
			orderBill.setTotalCost(customer.getCart().getCartTotal());
			return odRepo.save(orderBill);
		}
		throw new CustomerException("User must be customer...");
	}

	@Override
	public OrderBill updateOrderBill(OrderBill orderBill,String key) throws OrderBillException, CustomerException, LoginException {
		orderBill.setCreatedDate(LocalDate.now());
		CurrentUserSession status = sessionRepository.findByUuid(key);
		if(status==null) {
			throw new LoginException("Please Login first ...");
		}
		if(status.getRole().equalsIgnoreCase("customer")) {
			Optional<OrderBill> otp = odRepo.findById(orderBill.getOrderBillId());
			if(otp.isPresent()) {
				
				return odRepo.save(orderBill);
			}
			throw new OrderBillException("Order bill does not exist with the order id "+orderBill.getOrderBillId()); 
		}
		throw new CustomerException("User must be customer...");
	}
	
	@Override
	public OrderBill cancelOrderBill(Integer OrderBillId) throws OrderBillException {
		OrderBill orderBill= odRepo.findById(OrderBillId).orElseThrow(()-> new OrderBillException("Order bill does not exist with this id "+OrderBillId));
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
	public OrderBill showOrderBills(Integer OrderBillId) throws OrderBillException {
		return odRepo.findById(OrderBillId).orElseThrow(()-> new OrderBillException("Order bill does not exist with the id "+ OrderBillId));
	}

	
}
