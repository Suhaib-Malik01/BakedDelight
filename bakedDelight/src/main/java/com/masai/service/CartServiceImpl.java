package com.masai.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Dto.ProductDto;
import com.masai.exception.CartException;
import com.masai.exception.CustomerException;
import com.masai.exception.ProductException;
import com.masai.model.Cart;
import com.masai.model.CurrentUserSession;
import com.masai.model.Customer;
import com.masai.model.Product;
import com.masai.repository.CartRepository;
import com.masai.repository.CustomerRepository;
import com.masai.repository.ProductRepository;
import com.masai.repository.SessionRepository;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private SessionRepository sessionRepository;

	@Autowired
	private CartRepository cartRepository;

	@Override
	public Product addProductIntoCart(Integer id, String Key, Integer quantity)
			throws ProductException, CustomerException {
		CurrentUserSession status = sessionRepository.findByUuid(Key);

		Customer customer = customerRepository.findById(status.getUserId())
				.orElseThrow(() -> new CustomerException("Customer not found.."));

		Product product = productRepository.findById(id).orElseThrow(() -> new ProductException("Product Not found.."));

		if (quantity > product.getQuantity() || product.getAvailable() == false)
			throw new ProductException("Product Quantity is Not Enough...");

		customer.getCart().getProductList().put(product, quantity);

		product.setQuantity(product.getQuantity() - quantity);

		if (product.getQuantity() == 0)
			product.setAvailable(false);

		productRepository.save(product);

		updatedCart(customer.getCart());

		return product;
	}

	@Override
	public Cart removeProduct(Integer cartId, Integer prodId) throws ProductException, CartException {
		// TODO Auto-generated method stub

		Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new CartException("Cart Not found..."));

		Map<Product, Integer> products = cart.getProductList();

		Product product = productRepository.findById(prodId)
				.orElseThrow(() -> new ProductException("Product Not found..."));

		if (products.containsKey(product)) {

			product.setQuantity(product.getQuantity() + products.get(product));

			products.remove(product);

		} else {
			throw new ProductException("Product Not available in the cart");
		}
		productRepository.save(product);
		updatedCart(cart);

		return cart;
	}

	@Override
	public Cart updateProductQuantity(Integer cartId, Integer prodId, Integer quantity)
			throws CartException, ProductException {

		Product product = productRepository.findById(prodId)
				.orElseThrow(() -> new ProductException("No product found with product id: " + prodId));

		Cart cart = cartRepository.findById(cartId)
				.orElseThrow(() -> new CartException("No cart found with cart id: " + cartId));

		if (product.getAvailable() == false || product.getQuantity() < quantity)
			throw new ProductException(
					"Product is Out of Stock for this Quntity, Product left : " + product.getQuantity());

		cart.getProductList().replace(product, quantity);

		product.setQuantity(product.getQuantity() - quantity);
		if (product.getQuantity() == 0)
			product.setAvailable(false);

		productRepository.save(product);

		updatedCart(cart);

		return cart;
	}

	@Override
	public Cart removeAllProduct(Integer cartId) throws CartException {

		Cart cart = cartRepository.findById(cartId)
				.orElseThrow(() -> new CartException("No cart found with cart id: " + cartId));

		cart.setProductList(new HashMap<Product, Integer>());

		updatedCart(cart);

		return cart;
	}

	@Override
	public List<ProductDto> viewAllProduct(Integer cartId) throws CartException {
		// TODO Auto-generated method stub

		List<ProductDto> products = new ArrayList<>();

		Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new CartException("Cart Not Found..."));

		Map<Product, Integer> map = cart.getProductList();

		for (Product product: map.keySet()) {
			ProductDto productDto = new ProductDto(product.getProductID(),product.getName(),product.getPrice(),product.getDescription(),map.get(product),product.getCategory().getName());
			products.add(productDto);
		}

		return products;
	}

	public void updatedCart(Cart cart) {
		cart.setProductCount(cart.getProductList().size());

		double Total = 0;

		for (Product i : cart.getProductList().keySet()) {

			Total += i.getPrice() * cart.getProductList().get(i);

		}

		cart.setCartTotal(Total);

		cartRepository.save(cart);
	}

	
}
