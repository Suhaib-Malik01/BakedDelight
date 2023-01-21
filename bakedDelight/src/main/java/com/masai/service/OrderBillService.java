package com.masai.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.masai.exception.OrderBillException;
import com.masai.model.OrderBill;

public interface OrderBillService {
	public OrderBill addOrderBill(OrderBill orderBill) throws OrderBillException;
	
	public OrderBill updateOrderBill(OrderBill orderBill) throws OrderBillException;
	
	public OrderBill cancelOrderBill(Integer OrderBillId) throws OrderBillException;
	
	public List<OrderBill> showAllOrderBills() throws OrderBillException;
	
	public List<OrderBill> showAllOrderBills(Integer OrderBillId) throws OrderBillException;
}
