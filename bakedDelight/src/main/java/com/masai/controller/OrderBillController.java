package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.OrderBillException;
import com.masai.model.OrderBill;
import com.masai.service.OrderBillService;



@RestController
@RequestMapping("/orderbills")
public class OrderBillController {
	@Autowired
	private OrderBillService orderBillService;
	
	@PostMapping("/orderbills")
	public ResponseEntity<OrderBill> addOrderBillHandler(@Valid @RequestBody OrderBill orderBill) throws OrderBillException{
		return new ResponseEntity<OrderBill>(orderBillService.addOrderBill(orderBill), HttpStatus.CREATED);
	}
	
	@PutMapping("/orderbills")
	public ResponseEntity<OrderBill> updateOrderBillHandler(@Valid @RequestBody OrderBill orderBill) throws OrderBillException{
		return new ResponseEntity<OrderBill>(orderBillService.updateOrderBill(orderBill), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/orderbills/{id}")
	public ResponseEntity<OrderBill> deleteOrderBillHandler(@PathVariable("id") Integer id) throws OrderBillException{
		return new ResponseEntity<OrderBill>(orderBillService.cancelOrderBill(id), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/orderbills")
	public ResponseEntity<List<OrderBill>> showAllOrderBillHandler() throws OrderBillException{
		return new ResponseEntity<List<OrderBill>>(orderBillService.showAllOrderBills(), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/orderbills/{id}")
	public ResponseEntity<OrderBill> showOrderBillHandler(@PathVariable("id") Integer id) throws OrderBillException{
		return new ResponseEntity<OrderBill>(orderBillService.showOrderBills(id), HttpStatus.ACCEPTED);
	}
	
}
