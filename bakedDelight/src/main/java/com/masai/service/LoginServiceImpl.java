package com.masai.service;


import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.LoginException;
import com.masai.model.CurrentUserSession;
import com.masai.model.Customer;
import com.masai.model.User;
import com.masai.repository.CustomerRepository;
import com.masai.repository.SessionRepository;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private CustomerRepository cdao;
	
	@Autowired
	private SessionRepository sdao;

	@Override
<<<<<<< HEAD
	public CurrentUserSession LoginYourAccount(User user) throws LoginException {
=======
	public CurrentUserSession LoginIntoAccount(LoginDTO dto) throws LoginException {
		// Check if the user exists or not 
		Customer exist = cdao.findByUsername(dto.getUsername());
		if(exist == null) {
			throw new LoginException("Please Enter a valid Username");
		}
>>>>>>> 454c288985d26fa3a9cd77a423ab5f91e6d6cac2
		
		if (user.getRole().equals("admin")) {
			String uuid = UUID.randomUUID().toString();

			Random rand = new Random();

			int rand_int1 = rand.nextInt(100);

			CurrentUserSession userSession = new CurrentUserSession(rand_int1, uuid, LocalDateTime.now(),
					user.getUsername(), user.getPassword(), user.getRole());

			return sdao.save(userSession);
			// sdao.save(userSession);
			
		}

		// Check if the user exists or not
		Customer exist = cdao.findByUsername(user.getUsername());
		if (exist == null) {
			throw new LoginException("Please Enter a valid username");
		}

		CurrentUserSession checkLogin = sdao.findByUsername(exist.getUsername());

		if (checkLogin!= null ) {
			throw new LoginException(" You already Login SS");
		}

		if (exist.getPassword().equals(user.getPassword())) {
			
			String key = UUID.randomUUID().toString();
			
			CurrentUserSession userSession = new CurrentUserSession(exist.getUserId(), key, LocalDateTime.now(),
					user.getUsername(), user.getPassword(), user.getRole());
			sdao.save(userSession);
			return userSession;
		} else {
			throw new LoginException("Password doesn't match");
		}

	}

	@Override
	public String LogOutYourAccount(String key) throws LoginException {
		CurrentUserSession validUserSession = sdao.findByUuid(key);

		if (validUserSession == null) {

			throw new LoginException("User Not Logged in with this Email Id");
		}

		sdao.delete(validUserSession);
		return "Logged Out!";
	}

}
