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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CustomerException;
import com.masai.exception.LoginException;
import com.masai.exception.OrderBillException;
import com.masai.exception.SweetOrderException;
import com.masai.model.SweetOrder;
import com.masai.service.SweetOrderService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/sweetorders")
public class SweetOrderController {
	@Autowired
	private SweetOrderService sweetOrderService;
	
	@PostMapping("/addcartproduct/{key}")
	public ResponseEntity<SweetOrder> addSweetOrderHandler(@PathVariable("key")String key) throws SweetOrderException, LoginException, OrderBillException, CustomerException{
		SweetOrder order =	sweetOrderService.addSweetOrder(key);
		
		
		return new ResponseEntity<>(order,HttpStatus.ACCEPTED) ;
	}
	
	// @PutMapping("/updateorder/{sweetorderId}/{Key}")
	// public ResponseEntity<SweetOrder> updateSweetOrderHandler(@Valid @PathVariable("sweetorderId")Integer Id,@PathVariable String key ) throws SweetOrderException, LoginException, OrderBillException, CustomerException{
		
	// 	return new ResponseEntity<SweetOrder>(sweetOrderService.updateSweetOrder(Id,key), HttpStatus.OK);
	// }
	
	// @DeleteMapping("/delete/{id}")
	// public ResponseEntity<SweetOrder> cancelSweetOrderHandler(@PathVariable("id") Integer id) throws SweetOrderException, LoginException, OrderBillException, CustomerException{
		
	// 	return new ResponseEntity<SweetOrder>(sweetOrderService.cancelSweetOrder(id), HttpStatus.ACCEPTED);
	// }
	
	// @GetMapping("/showAll")
	// public ResponseEntity<List<SweetOrder>> showAllSweetOrderHandler() throws SweetOrderException{
		
	// 	return new ResponseEntity<List<SweetOrder>>(sweetOrderService.showAllSweetOrder(), HttpStatus.OK);
	// }
	
	// @GetMapping("/total/{id}")
	// public ResponseEntity<Double> calculateTotalCostOfSweetOrderHandler(@PathVariable("id") Integer id) throws SweetOrderException{
		
	// 	return new ResponseEntity<Double>(sweetOrderService.calculateTotalCost(id), HttpStatus.CREATED);
	// }
}
