package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CustomerException;
import com.masai.exception.LoginException;
import com.masai.model.Customer;
import com.masai.service.CustomerService;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class customerController {

    @Autowired
    private CustomerService cService;

    @PostMapping("/customer")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) throws CustomerException{

        Customer storedCustomer = cService.addCustomer(customer);

        return new ResponseEntity<Customer>(storedCustomer, HttpStatus.ACCEPTED);

    }
    
    @PutMapping("/customer")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) throws CustomerException{

        Customer storedCustomer = cService.updateCustomer(customer);

        return new ResponseEntity<Customer>(storedCustomer, HttpStatus.ACCEPTED);

    }

    @DeleteMapping("/customer/{id}/{key}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable Integer id,@PathVariable String key) throws CustomerException, LoginException{

        Customer customer = cService.deleteCustomer(id,key);

        return new ResponseEntity<Customer>(customer, HttpStatus.ACCEPTED);

    }

    @GetMapping("/customer/{id}/{key}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Integer id,@PathVariable String key) throws CustomerException, LoginException{

        Customer customer = cService.getCustomer(id,key);

        return new ResponseEntity<Customer>(customer, HttpStatus.OK);

    }

    @GetMapping("/customer/{key}")
    public ResponseEntity<List<Customer>> getAllCustomer(@PathVariable String key) throws CustomerException, LoginException{

        List<Customer> customer = cService.getAllCustomer(key);

        return new ResponseEntity<>(customer, HttpStatus.OK);

    }
}
