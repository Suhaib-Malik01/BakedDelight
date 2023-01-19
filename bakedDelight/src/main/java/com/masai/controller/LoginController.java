package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.LoginException;
import com.masai.model.CurrentUserSession;
import com.masai.model.LoginDTO;
import com.masai.service.*;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class LoginController {
	
	@Autowired
	private LoginService culogin;
	
	@PostMapping("/login")
	public ResponseEntity<CurrentUserSession> loginCustomerHandler(@RequestBody LoginDTO dto) throws LoginException{
		CurrentUserSession cus = culogin.LoginIntoAccount(dto);
		return new ResponseEntity<>(cus, HttpStatus.OK);
	}
	
	
	@PostMapping("/logout")
	public ResponseEntity<String> logoutCustomerHandler(@RequestParam("token") String key) throws LoginException {
		
	String res = culogin.LogoutFromAccount(key)	;
	
	return new ResponseEntity<>(res, HttpStatus.OK);
		
	}
	
	@PostMapping("/logoutfromall")
	public ResponseEntity<String> logoutFromAllDeviceHandler(@RequestParam("token") String key) throws LoginException{
		String res = culogin.LogoutFromAllAccounts(key);
		return new ResponseEntity<>(res, HttpStatus.OK);
		
	}
	

}
