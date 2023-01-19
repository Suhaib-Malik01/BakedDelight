package com.masai.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.LoginException;
import com.masai.model.CurrentUserSession;
import com.masai.model.Customer;
import com.masai.model.LoginDTO;
import com.masai.repository.CustomerRepository;
import com.masai.repository.SessionRepository;
@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private CustomerRepository cdao;
	
	@Autowired
	private SessionRepository sdao;

	@Override
	public CurrentUserSession LoginIntoAccount(LoginDTO dto) throws LoginException {
		// Check if the user exists or not 
		Customer exist = cdao.findByUsername(dto.getUsername());
		if(exist == null) {
			throw new LoginException("Please Enter a valid Username");
		}
		
		// Validate Password
		if(exist.getPassword().equals(dto.getPassword())) {
			String uuid = UUID.randomUUID().toString();
		CurrentUserSession cus = new CurrentUserSession(uuid, exist.getUserId(), LocalDateTime.now());
		sdao.save(cus);
		return cus;
		}
		
		else {
			// Throw exception on invalid password
			throw new LoginException("Please enter a valid password!");
		}
		
	}

	@Override
	public String LogoutFromAccount(String key) throws LoginException {
		// Validate token 
		CurrentUserSession cus = sdao.findByUuid(key);
		if(cus == null) {
			throw new LoginException("Invalid operation!");
		}
		//Log out
		sdao.delete(cus);
		return "Logged Out!";
	}

	@Override
	public String LogoutFromAllAccounts(String key) throws LoginException {
		// Validate current user token
		CurrentUserSession cus = sdao.findByUuid(key);
		if(cus == null) {
			throw new LoginException("Access denied!");
		}
		
		// Get list of current sessions running 
		List<CurrentUserSession> sessions = sdao.findByUserId(cus.getUserId());
		
		
		// Remove all except the current user
		for(CurrentUserSession session : sessions) {
			if(session.getUuid()!= cus.getUuid())
				sdao.delete(session);
		}
		 
		// Return success message
		return "Logged out from all devices!";
	}

}
