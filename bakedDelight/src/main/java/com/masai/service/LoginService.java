package com.masai.service;

import com.masai.exception.LoginException;
import com.masai.model.*;

public interface LoginService {

	public CurrentUserSession LoginYourAccount(User user) throws LoginException;

	public String LogOutYourAccount(String key) throws LoginException;

}
