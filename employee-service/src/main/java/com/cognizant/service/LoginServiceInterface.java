package com.cognizant.service;

import com.cognizant.entities.Login;

public interface LoginServiceInterface {
	
	public Login hrLogin(Login login);
	
	public Login searchById(int id);
}
