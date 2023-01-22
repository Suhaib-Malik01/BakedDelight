 package com.masai.service;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.context.spi.CurrentSessionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.masai.exception.CustomerException;
import com.masai.exception.LoginException;
import com.masai.exception.OrderBillException;
import com.masai.exception.SweetOrderException;
import com.masai.model.CurrentUserSession;
import com.masai.model.Customer;
import com.masai.model.OrderBill;
import com.masai.model.SweetOrder;
import com.masai.repository.CartRepository;
import com.masai.repository.CustomerRepository;
import com.masai.repository.SessionRepository;
import com.masai.repository.SweetOrderRepository;

@Service
public class SweetOrderServiceImpl implements SweetOrderService{

	@Autowired
	private SweetOrderRepository soRepo; 
	
	@Autowired
	private SessionRepository sessionRepository;
	
	@Autowired
	private CustomerRepository cRepo;
	
	@Autowired
	private OrderBillService orderBillService;
	
	@Override
	public SweetOrder addSweetOrder(SweetOrder sweetOrder, String key) throws SweetOrderException, LoginException, OrderBillException, CustomerException {
		CurrentUserSession status = sessionRepository.findByUuid(key);
		if(status==null) throw new LoginException("Please Login first ...");
		if(status.getRole().equalsIgnoreCase("customer")) {
			Customer customer= cRepo.findById(status.getUserId()).orElseThrow(()->new LoginException("User is not register..."));
			
			sweetOrder.setCart(customer.getCart());
			sweetOrder.setDate(LocalDate.now());
			
			OrderBill orderBill = new OrderBill();
			orderBill.setOrder(sweetOrder);
			
			sweetOrder.setTotalCost(sweetOrder.getCart().getCartTotal());
			sweetOrder.setOrderBill(orderBillService.addOrderBill(orderBill, key));
			
			return soRepo.save(sweetOrder);
		}
		throw new CustomerException("User must be customer...");

	}
	
	@Override
	public SweetOrder updateSweetOrder(SweetOrder sweetOrder, String key) throws SweetOrderException, LoginException, CustomerException, OrderBillException {
		CurrentUserSession status = sessionRepository.findByUuid(key);
		if(status==null) {
			throw new LoginException("Please Login first ...");
		}
		if(status.getRole().equalsIgnoreCase("customer")) {
			Customer customer= cRepo.findById(status.getUserId()).orElseThrow(()->new LoginException("User is not register..."));
			
			SweetOrder sweetOrder1= soRepo.findById(sweetOrder.getSweetOrderId()).orElseThrow(()-> new SweetOrderException("Sweet Order does not exist with Id "+sweetOrder.getSweetOrderId()));
			OrderBill orderBill= sweetOrder1.getOrderBill();
			orderBill.setOrder(sweetOrder);
			orderBill.setTotalCost(sweetOrder.getTotalCost());
			sweetOrder.setDate(LocalDate.now());
			
			sweetOrder.setOrderBill(orderBillService.updateOrderBill(orderBill, key));
			
			return soRepo.save(sweetOrder);
		}
		throw new CustomerException("User must be customer...");
		
	}

	@Override
	public SweetOrder cancelSweetOrder(Integer sweetOrderId, String key) throws SweetOrderException, LoginException, OrderBillException, CustomerException {
		CurrentUserSession status = sessionRepository.findByUuid(key);
		if(status==null) {
			throw new LoginException("Please Login first ...");
		}
		if(status.getRole().equalsIgnoreCase("customer")) {
			Customer customer= cRepo.findById(status.getUserId()).orElseThrow(()->new LoginException("User is not register..."));
			
			SweetOrder sweetOrder= soRepo.findById(sweetOrderId).orElseThrow(()-> new SweetOrderException("Sweet Order does not exist with Id "+sweetOrderId));
			
			orderBillService.cancelOrderBill(sweetOrder.getOrderBill(), key);
			
			soRepo.delete(sweetOrder);
			
			return sweetOrder;
			
		}
		throw new CustomerException("User must be customer...");
		
		
		
		
		
		
		
		
		
		
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