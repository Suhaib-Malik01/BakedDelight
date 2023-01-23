package com.masai.service;

import java.util.List;

import com.masai.exception.CustomerException;
import com.masai.exception.LoginException;
import com.masai.model.Customer;

public interface CustomerService {

    public Customer addCustomer(Customer customer) throws CustomerException;

    public Customer updateCustomer(Customer customer) throws CustomerException;

    public Customer deleteCustomer(Integer customerId,String key) throws CustomerException, LoginException;

    public Customer getCustomer(Integer customerId,String key) throws CustomerException, LoginException;

    public List<Customer> getAllCustomer(String key) throws CustomerException, LoginException;

}
