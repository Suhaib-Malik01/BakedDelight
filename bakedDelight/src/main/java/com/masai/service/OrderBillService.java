package com.masai.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.masai.exception.OrderBillException;
import com.masai.model.OrderBill;

public interface OrderBillService {
	public ResponseEntity<OrderBill> addOrderBill(OrderBill orderBill) throws OrderBillException;
	
	public ResponseEntity<OrderBill> updateOrderBill(OrderBill orderBill) throws OrderBillException;
	
	public ResponseEntity<OrderBill> cancelOrderBill(Integer OrderBillId) throws OrderBillException;
	
	public ResponseEntity<List<OrderBill>> showAllOrderBills() throws OrderBillException;
	
	public ResponseEntity<List<OrderBill>> showAllOrderBills(Integer OrderBillId) throws OrderBillException;
}
