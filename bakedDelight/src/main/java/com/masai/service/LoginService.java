package com.masai.service;

import com.masai.exception.LoginException;
import com.masai.model.*;


public interface LoginService {
	
	public CurrentUserSession LoginIntoAccount(LoginDTO dto) throws LoginException;

	public String LogoutFromAccount(String key) throws LoginException;
	
	public String LogoutFromAllAccounts(String key) throws LoginException;
}
