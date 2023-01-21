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

import com.masai.exception.SweetOrderException;
import com.masai.model.SweetOrder;
import com.masai.service.SweetOrderService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/sweetorders")
public class SweetOrderController {
	@Autowired
	private SweetOrderService sweetOrderService;
	
	@PostMapping("/sweetorders")
	public ResponseEntity<SweetOrder> addSweetOrderHandler(@Valid @RequestBody SweetOrder sweetOrder ) throws SweetOrderException{
		
		return new ResponseEntity<SweetOrder>(sweetOrderService.addSweetOrder(sweetOrder), HttpStatus.CREATED);
	}
	
	@PutMapping("/sweetorders")
	public ResponseEntity<SweetOrder> updateSweetOrderHandler(@Valid @RequestBody SweetOrder sweetOrder ) throws SweetOrderException{
		
		return new ResponseEntity<SweetOrder>(sweetOrderService.updateSweetOrder(sweetOrder), HttpStatus.OK);
	}
	
	@DeleteMapping("/sweetorders/{id}")
	public ResponseEntity<SweetOrder> cancelSweetOrderHandler(@PathVariable("id") Integer id) throws SweetOrderException{
		
		return new ResponseEntity<SweetOrder>(sweetOrderService.cancelSweetOrder(id), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/sweetorders")
	public ResponseEntity<List<SweetOrder>> showAllSweetOrderHandler() throws SweetOrderException{
		
		return new ResponseEntity<List<SweetOrder>>(sweetOrderService.showAllSweetOrder(), HttpStatus.OK);
	}
	
	@GetMapping("/sweetorders/{id}")
	public ResponseEntity<Double> calculateTotalCostOfSweetOrderHandler(@PathVariable("id") Integer id) throws SweetOrderException{
		
		return new ResponseEntity<Double>(sweetOrderService.calculateTotalCost(id), HttpStatus.CREATED);
	}
}
