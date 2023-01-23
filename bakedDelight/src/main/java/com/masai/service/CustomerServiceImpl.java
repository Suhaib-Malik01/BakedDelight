package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CustomerException;
import com.masai.exception.LoginException;
import com.masai.model.Cart;
import com.masai.model.CurrentUserSession;
import com.masai.model.Customer;
import com.masai.repository.CustomerRepository;
import com.masai.repository.SessionRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository cDao;

    @Autowired
	public SessionRepository sessionRepo;
    
    @Override
    public Customer addCustomer(Customer customer){
        
        customer.setCart(new Cart());

        return cDao.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) throws CustomerException {
        
        
        cDao.findById(customer.getUserId()).orElseThrow(()->new CustomerException("Customer Not Found..."));

        return cDao.save(customer);
    }

    @Override
    public Customer deleteCustomer(Integer customerId,String key) throws CustomerException, LoginException {
        
        CurrentUserSession status =	sessionRepo.findByUuid(key);
		
        if(status==null) {
			
			throw new LoginException("Customer not logged yet..plz login first");
			
		}
		
		if(status.getRole().equalsIgnoreCase("customer")) {
			
			throw new CustomerException("You are not authorized to add products");
			
		}
        
        Customer customer = cDao.findById(customerId).orElseThrow(()-> new CustomerException("Customer Not Found..."));

        cDao.delete(customer);

        return customer;
    }

    @Override
    public Customer getCustomer(Integer customerId,String key) throws CustomerException, LoginException {
        
        CurrentUserSession status =	sessionRepo.findByUuid(key);
		
        if(status==null) {
			
			throw new LoginException("Customer not logged yet..plz login first");
			
		}
		
		if(status.getRole().equalsIgnoreCase("customer")) {
			
			throw new CustomerException("You are not authorized to add products");
			
		}

        Customer customer = cDao.findById(customerId).orElseThrow(()-> new CustomerException("Customer Not Found..."));

        return customer;
    }

    @Override
    public List<Customer> getAllCustomer(String key) throws CustomerException, LoginException {
        
        CurrentUserSession status =	sessionRepo.findByUuid(key);
		
        if(status==null) {
			
			throw new LoginException("Customer not logged yet..plz login first");
			
		}
		
		if(status.getRole().equalsIgnoreCase("customer")) {
			
			throw new CustomerException("You are not authorized to add products");
			
		}
        
        List<Customer> customers = cDao.findAll();

        if(customers.size()==0) throw new CustomerException("Customers Not found...");

        return customers;
    }
    
}
