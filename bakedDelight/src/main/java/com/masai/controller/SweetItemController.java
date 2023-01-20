package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.ProductException;
import com.masai.exception.SweetItemException;
import com.masai.model.SweetItem;
import com.masai.service.SweetItemService;

@RestController
public class SweetItemController {

	@Autowired
	private SweetItemService sweetItemService;

	/*------------------------------------------Add Sweet Items-------------------------------------------------*/

	@PostMapping("/sweetitems/{quantity}/{key}/{pid}")
	public ResponseEntity<SweetItem> addSweetItemHandler(@PathVariable("quantity") Double quantity, @PathVariable("key") String key,@PathVariable("pid") Integer pid) throws SweetItemException, ProductException {

		SweetItem savedSweetItem = sweetItemService.addSweetItem(quantity,key,pid);

		return new ResponseEntity<SweetItem>(savedSweetItem, HttpStatus.CREATED);

	}

	/*------------------------------------------View All SweetItems-------------------------------------------------*/
	
    @GetMapping("/allsweetitems")
	public ResponseEntity<List<SweetItem>> showAllSweetItemsHandler() throws SweetItemException {

		List<SweetItem> sweetItems = sweetItemService.showAllSweetItems(null);

		return new ResponseEntity<>(sweetItems, HttpStatus.OK);

	}
	
	/*------------------------------------------Cancel SweetItem-------------------------------------------------*/

	
	@DeleteMapping("/sweetitems/{id}")
	public ResponseEntity<SweetItem> cancelSweetItemHandler(@PathVariable("id") Integer id) throws SweetItemException{
		SweetItem sweetItem= sweetItemService.cancelSweetItemById(id, null);
		           
		           return new ResponseEntity<>(sweetItem,HttpStatus.ACCEPTED);
	}
	
	
	/*------------------------------------------Update SweetItem-------------------------------------------------*/

	
	@PatchMapping("/updatesweetitems")
	public ResponseEntity<SweetItem> updateSweetItemHandler(@RequestBody SweetItem sweetItem ) throws SweetItemException{
		SweetItem savedSweetItem=  sweetItemService.updateSweetItem(sweetItem, null);
		                   
		                   return new ResponseEntity<>(savedSweetItem,HttpStatus.OK);
	}
	
}
