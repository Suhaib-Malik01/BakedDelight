package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.masai.exception.LoginException;
import com.masai.model.CurrentUserSession;
import com.masai.model.User;
import com.masai.service.*;

@RestController
public class LoginController {
	
	@Autowired
	private LoginService culogin;
	
	@PostMapping("/login")
	public ResponseEntity<CurrentUserSession> LoginUser( @RequestBody User user ) throws LoginException {
		
		if(user.getUsername().equals("admin@gmail.com") && user.getPassword().equals("admin")) {
			
			user.setRole("admin");
			
			CurrentUserSession login = culogin.LoginYourAccount(user);
			 return new ResponseEntity<CurrentUserSession>(login,HttpStatus.ACCEPTED);	
		}
		
		else {
			
			user.setRole("customer");
			
			 CurrentUserSession login = culogin.LoginYourAccount(user);
			 
			 return new ResponseEntity<CurrentUserSession>(login,HttpStatus.ACCEPTED);	
		}
	}
	
	@DeleteMapping("/logout/{key}")
	public ResponseEntity<String> logoutCustomer( @PathVariable String key) throws LoginException{
		
		String logout = culogin.LogOutYourAccount(key);
		
		return new ResponseEntity<>(logout, HttpStatus.ACCEPTED);
		
	}

}
