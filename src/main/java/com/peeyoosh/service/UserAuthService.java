package com.peeyoosh.service;

import org.springframework.stereotype.Service;

@Service	// It is managed by spring. Spring will create instance of this bean.
public class UserAuthService {

	public boolean isUserValid(String username, String password) {
		return username.equalsIgnoreCase("Peeyoosh") && password.equals("123456");
	}
}
