package com.masai.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.masai.exception.OrderBillException;
import com.masai.model.OrderBill;

public class OrderBillServiceImpl implements OrderBillService{

	@Override
	public ResponseEntity<OrderBill> addOrderBill(OrderBill orderBill) throws OrderBillException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<OrderBill> updateOrderBill(OrderBill orderBill) throws OrderBillException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<OrderBill> cancelOrderBill(Integer OrderBillId) throws OrderBillException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<List<OrderBill>> showAllOrderBills() throws OrderBillException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<List<OrderBill>> showAllOrderBills(Integer OrderBillId) throws OrderBillException {
		// TODO Auto-generated method stub
		return null;
	}

}
