package com.masai.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.masai.exception.CustomerException;
import com.masai.exception.LoginException;
import com.masai.exception.OrderBillException;
import com.masai.exception.SweetOrderException;
import com.masai.model.SweetOrder;

public interface SweetOrderService {
	
	
    public SweetOrder addSweetOrder( String key) throws SweetOrderException, LoginException, OrderBillException, CustomerException;
	
	public SweetOrder updateSweetOrder(Integer sweetorderId, String key) throws SweetOrderException, LoginException, OrderBillException, CustomerException;
	
	public SweetOrder cancelSweetOrder(Integer sweetOrderId) throws SweetOrderException, LoginException, OrderBillException, CustomerException;
	
	public List<SweetOrder> showAllSweetOrder() throws SweetOrderException;
	
	public Double calculateTotalCost(Integer sweetOrderId) throws SweetOrderException;
	
	

}