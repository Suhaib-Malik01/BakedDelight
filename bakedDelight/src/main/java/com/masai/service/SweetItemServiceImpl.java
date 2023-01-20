package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.ProductException;
import com.masai.exception.SweetItemException;
import com.masai.model.Product;
import com.masai.model.SweetItem;
import com.masai.repository.ProductRepository;
import com.masai.repository.SweetItemRepository;

@Service
public class SweetItemServiceImpl implements SweetItemService {

	@Autowired
	private SweetItemRepository sweetItemRepository;

	@Autowired
	private ProductRepository productRepo;

	/*------------------------------------------Add Sweet Items Handler-------------------------------------------------*/

	@Override
	public SweetItem addSweetItem(Double quantity, String key, Integer pId)
			throws SweetItemException, ProductException {

		// key

//		Optional<Product> productOptional = productRepo.findById(pId);
//
//		if (productOptional.isPresent()) {
//
//			Product product = productOptional.get();
//
//			if (!product.getAvailable()) {
//				throw new ProductException("Product is out of stock.. ");
//			}
//			if (product.getQuantity() < quantity) {
//				throw new ProductException("There is only " + product.getQuantity() + " available... ");
//			}
//			product.setQuantity(product.getQuantity()-quantity);
//			
//			productRepo.save(product);
//
//			SweetItem sItem = new SweetItem();
//			
//			//sItem.setQuantity(sweetItemRepository.findAll().size());
//
//			sItem.getProductList().add(product);
//			
//		return	sweetItemRepository.save(sItem);
//			
//			
//
//		}
//
//		else {
//			throw new ProductException("Product not found with id : " + pId);
//		}

//		SweetItem savedSweetItem = sweetItemRepository.save(sweetItem);
//
//		if (savedSweetItem == null) {
//			throw new SweetItemException("SweetItem doesn't saved....");
//
//		} else {
//			//return savedSweetItem;
//			
//			savedSweetItem
//
//		}
     return null;
	}

	/*------------------------------------------View All SweetItems Handler-------------------------------------------------*/

	@Override
	public List<SweetItem> showAllSweetItems(String key) throws SweetItemException {

		List<SweetItem> sweetItems = sweetItemRepository.findAll();

		if (sweetItems.size() == 0) {
			throw new SweetItemException("SweetItems doesn't exist....");

		} else {
			return sweetItems;

		}

	}

	/*------------------------------------------Cancel SweetItem Handler-------------------------------------------------*/

	@Override
	public SweetItem cancelSweetItemById(Integer id, String Key) throws SweetItemException {

		Optional<SweetItem> sweetItem = sweetItemRepository.findById(id);

		if (!sweetItem.isEmpty()) {
			SweetItem existingsweetItem = sweetItem.get();

			sweetItemRepository.delete(existingsweetItem);
			return existingsweetItem;
		} else
			throw new SweetItemException("SweetItem not found with id : " + id);

	}

	/*------------------------------------------Update SweetItem Handler-------------------------------------------------*/

	@Override
	public SweetItem updateSweetItem(SweetItem sweetItem, String Key) throws SweetItemException {

		Optional<SweetItem> sweetItemOpt = sweetItemRepository.findById(sweetItem.getOrderItemId());

		if (sweetItemOpt.isPresent()) {
			return sweetItemRepository.save(sweetItem);
		} else {
			throw new SweetItemException("SweetItem not found with id : " + sweetItem.getOrderItemId());
		}
	}

}
