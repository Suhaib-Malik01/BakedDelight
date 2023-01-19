package com.masai.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.masai.exception.LoginException;
import com.masai.model.User;
import com.masai.service.*;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class LoginController {
	
	@Autowired
	private LoginService culogin;
	
	@PostMapping("/login")
	public ResponseEntity<String> LoginUser( @RequestBody User user ) throws LoginException {
		
		if(user.getUsername().equals("admin@gmail.com") && user.getPassword().equalsIgnoreCase("admin")) {
			
			user.setRole("admin");
			
			String login = culogin.LoginYourAccount(user);
			 return new ResponseEntity<String>(login,HttpStatus.OK);
			
		}else {
			
			user.setRole("customer");
			
			 String login = culogin.LoginYourAccount(user);
			 return new ResponseEntity<String>(login,HttpStatus.OK);
			
		}
		
	}
	
	@DeleteMapping("/logout/{k}")
	public String logoutCustomer( @PathVariable("k") String key) throws LoginException{
		return culogin.LogOutYourAccount(key);
		
	}

	

}
