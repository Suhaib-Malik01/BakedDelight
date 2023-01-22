package com.masai.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.masai.exception.CustomerException;
import com.masai.exception.LoginException;
import com.masai.exception.OrderBillException;
import com.masai.model.OrderBill;

public interface OrderBillService {
	public OrderBill addOrderBill(OrderBill orderBill, String key) throws OrderBillException, LoginException, CustomerException; 
	
	public OrderBill updateOrderBill(OrderBill orderBill,String key) throws OrderBillException, CustomerException, LoginException ;
	
	public OrderBill cancelOrderBill(sweetOrder.getOrderBill(), key) throws OrderBillException, CustomerException, LoginException ;
	
	public List<OrderBill> showAllOrderBills() throws OrderBillException;
	
	public OrderBill showOrderBills(Integer OrderBillId) throws OrderBillException;
}
