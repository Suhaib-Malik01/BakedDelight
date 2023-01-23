package com.masai.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.masai.Dto.ProductDto;
import com.masai.exception.OrderBillException;
import com.masai.model.OrderBill;
import com.masai.model.Product;
import com.masai.model.SweetOrder;
import com.masai.repository.OrderBillRepository;
import com.masai.repository.SweetOrderRepository;

@Service
public class OrderBillServiceImpl implements OrderBillService {

	@Autowired
	private OrderBillRepository odRepo;

	@Autowired
	private SweetOrderRepository sweetOrderrepo;

	@Override
	public OrderBill addOrderBill(Integer sweetOrderId) throws OrderBillException {
		Optional<SweetOrder> opt = sweetOrderrepo.findById(sweetOrderId);
		if (opt.isEmpty())
			throw new OrderBillException("Please check sweetOrderId: " + sweetOrderId);
		SweetOrder order = opt.get();

		OrderBill bill = new OrderBill();
		bill.setCreatedDate(LocalDate.now());
		bill.setOrder(order);
		bill.setTotalCost(order.getTotalCost());

		return odRepo.save(bill);
	}

	@Override
	public List<ProductDto> showOrderBills(Integer OrderBillId) throws OrderBillException {
		OrderBill orderBill = odRepo.findById(OrderBillId)
				.orElseThrow(() -> new OrderBillException("Order bill does not exist with the id " + OrderBillId));

		Map<Product, Integer> products = orderBill.getOrder().getCart().getProductList();

		List<ProductDto> productDtoList = new ArrayList<>();

		for (Product product : products.keySet()) {
			productDtoList.add(new ProductDto(product.getProductID(), product.getName(),
					product.getPrice() * products.get(product), product.getDescription(), products.get(product),
					product.getCategory().getName()));
		}

		orderBill.getOrder().getCart().setProductList(new HashMap<>());

		odRepo.save(orderBill);
		return productDtoList;
	}

}
