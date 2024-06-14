package com.cognizant.controller;

import java.util.Base64;
import java.util.Base64.Encoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.entities.Login;
import com.cognizant.service.LoginServiceInterface;

@RestController
@RequestMapping("/logins")
@CrossOrigin(origins = "http://localhost:4200/")
public class LoginController {

	@Autowired
	private LoginServiceInterface loginser;
	
	@PostMapping("/addLogin")
	public ResponseEntity<Login> addLogin(@RequestBody Login login){
		Encoder encode = Base64.getEncoder();
		String encrpt = encode.encodeToString(login.getPassword().getBytes());
		login.setPassword(encrpt);
		Login log = loginser.hrLogin(login);
		return new ResponseEntity<Login> (log,HttpStatus.CREATED);
		
	}
	@GetMapping("/getById/{id}")
	public ResponseEntity<Login> searchById(@PathVariable int id){
		Login log = loginser.searchById(id);
		return new ResponseEntity<>(HttpStatus.OK);
//		return new ResponseEntity<>(log,HttpStatus.OK);
	}
}
