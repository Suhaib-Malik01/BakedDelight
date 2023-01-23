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

import com.masai.Dto.ProductDto;
import com.masai.exception.OrderBillException;
import com.masai.model.OrderBill;
import com.masai.service.OrderBillService;



@RestController
@RequestMapping("/orderbills")
public class OrderBillController {
	@Autowired
	private OrderBillService orderBillService;
	
	@PostMapping("/orderbills/{sweetorderId}")
	public ResponseEntity<OrderBill> addOrderBillHandler(@Valid @PathVariable("sweetorderId")Integer sweetorderId) throws OrderBillException{
		return new ResponseEntity<OrderBill>(orderBillService.addOrderBill(sweetorderId), HttpStatus.CREATED);
	}
	
	
	
	@GetMapping("/orderbills/{OrderBillId}")
	public ResponseEntity<List<ProductDto>> showOrderBillHandler(@PathVariable("OrderBillId") Integer id) throws OrderBillException{
		return new ResponseEntity<>(orderBillService.showOrderBills(id), HttpStatus.ACCEPTED);
	}
	
}
