package com.cognizant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.entities.Login;
import com.cognizant.repositories.LoginInterface;

@Service
public class LoginServiceImpl implements LoginServiceInterface {
	
	@Autowired
	private LoginInterface loginrepo;

	@Override
	public Login hrLogin(Login login) {
		// TODO Auto-generated method stub
		Login log = loginrepo.save(login);
		return log;
	}

	@Override
	public Login searchById(int id) {
		// TODO Auto-generated method stub
		
		return loginrepo.findById(id).get();
	}

	
	

	

}
