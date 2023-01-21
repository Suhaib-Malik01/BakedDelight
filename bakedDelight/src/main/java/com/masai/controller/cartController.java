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

import com.masai.Dto.ProductDto;
import com.masai.exception.CartException;
import com.masai.exception.CustomerException;
import com.masai.exception.ProductException;
import com.masai.model.Cart;
import com.masai.model.Product;
import com.masai.service.CartService;

@RestController
public class cartController {

    @Autowired
    private CartService cartService;
    

    @PostMapping("/cart/{id}/{key}/{quantity}")
    public ResponseEntity<Product> addProduct(@PathVariable Integer id,@PathVariable String key,@PathVariable Integer quantity) throws ProductException, CustomerException{

        Product product = cartService.addProductIntoCart(id, key,quantity);

        return new ResponseEntity<Product>(product, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/cart/{cartId}/{id}")
    public ResponseEntity<Cart> deleteProduct(@PathVariable Integer cartId,@PathVariable Integer id) throws ProductException, CartException{

        Cart cart = cartService.removeProduct(cartId, id);

        return new ResponseEntity<Cart>(cart, HttpStatus.ACCEPTED);
    }

    @PutMapping("/cart/{cartId}/{pid}/{quantity}")
    public ResponseEntity<Cart> updateProduct(@PathVariable Integer cartId,@PathVariable Integer pid ,@PathVariable Integer quantity) throws ProductException, CartException{

        Cart cart = cartService.updateProductQuantity(cartId, pid, quantity);

        return new ResponseEntity<Cart>(cart, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/cart/{cartId}")
    public ResponseEntity<Cart> removeAllProductFromCart(@PathVariable Integer cartId) throws ProductException, CartException{

        Cart cart = cartService.removeAllProduct(cartId);

        return new ResponseEntity<Cart>(cart, HttpStatus.ACCEPTED);
    }

    @GetMapping("/cart/{cartId}")

    public ResponseEntity<List<ProductDto>> getAllProduct(@PathVariable Integer cartId) throws CartException{
        
        List<ProductDto> products = cartService.viewAllProduct(cartId);

        return new ResponseEntity<>(products, HttpStatus.OK);

    }





}
