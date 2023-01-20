package com.masai.service;


import java.util.List;

import com.masai.exception.ProductException;
import com.masai.exception.SweetItemException;
import com.masai.model.SweetItem;

public interface SweetItemService {
	
	public SweetItem addSweetItem(Double quantity, String Key, Integer pId) throws SweetItemException,ProductException;

	public List<SweetItem> showAllSweetItems(String key)throws SweetItemException;
	
	public SweetItem cancelSweetItemById(Integer id, String Key) throws SweetItemException;
	
	public SweetItem updateSweetItem(SweetItem sweetItem, String Key) throws SweetItemException;
}
                                       