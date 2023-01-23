 package com.masai.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.masai.exception.CustomerException;
import com.masai.exception.LoginException;
import com.masai.exception.OrderBillException;
import com.masai.exception.SweetOrderException;
import com.masai.model.Cart;
import com.masai.model.CurrentUserSession;
import com.masai.model.Customer;
import com.masai.model.OrderBill;
import com.masai.model.Product;
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
	private CustomerRepository customerRepo;
	
	@Autowired
	private CartRepository cartrepo;
	
	@Autowired
	private OrderBillService orderBillService;
	
	@Override
	public SweetOrder addSweetOrder(String key) throws SweetOrderException, LoginException, OrderBillException, CustomerException{
		CurrentUserSession status = sessionRepository.findByUuid(key);
		
		if(status==null) throw new LoginException("Please Login first ...");
		
		
		if(status.getRole().equalsIgnoreCase("customer")) {
			Customer customer= customerRepo.findById(status.getUserId()).orElseThrow(()->new LoginException("User is not register..."));
			
			Cart custCart = customer.getCart();
			
		  Map<Product,Integer> prodmap =custCart.getProductList();
		
		 if(prodmap.isEmpty())throw new SweetOrderException("Your Cart is Empty! Please Add Products to your cart before Ordering");
		  
		   SweetOrder sweetOrder =new SweetOrder();
		   
			sweetOrder.setCart(custCart);
			sweetOrder.setDate(LocalDate.now());
			
			sweetOrder.setTotalCost(sweetOrder.getCart().getCartTotal());			
			
			cartrepo.save(custCart);
			customerRepo.save(customer);
			 
			return soRepo.save(sweetOrder);
		}
		throw new CustomerException("User must be customer...");
	}
	
	@Override
	public SweetOrder updateSweetOrder(Integer sweetorderId,String key) throws SweetOrderException, LoginException, OrderBillException, CustomerException {
		
		SweetOrder sweetOrder= soRepo.findById(sweetorderId).orElseThrow(()-> new SweetOrderException("Sweet Order does not exist with Id "+sweetorderId));
		CurrentUserSession status = sessionRepository.findByUuid(key);
		
		Customer customer= customerRepo.findById(status.getUserId()).orElseThrow(()->new LoginException("User is not register..."));

		sweetOrder.getCart().getProductList().putAll(customer.getCart().getProductList());
		return soRepo.save(sweetOrder);
	}

	@Override
	public SweetOrder cancelSweetOrder(Integer sweetOrderId) throws SweetOrderException, LoginException, OrderBillException, CustomerException {
		SweetOrder sweetOrder= soRepo.findById(sweetOrderId).orElseThrow(()-> new SweetOrderException("Sweet Order does not exist with Id "+sweetOrderId));
		
	   Map<Product,Integer> map =	sweetOrder.getCart().getProductList();
			
		
		
		
		
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