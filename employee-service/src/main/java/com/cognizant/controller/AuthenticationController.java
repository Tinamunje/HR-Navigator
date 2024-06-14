package com.cognizant.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.entities.AuthenticationResponse;
import com.cognizant.entities.Employee;
import com.cognizant.service.AuthenticationService;

@RestController
@CrossOrigin(origins = "*")
public class AuthenticationController {

    private final AuthenticationService authService;

    public AuthenticationController(AuthenticationService authService) {
        this.authService = authService;
    }


    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody Employee request
            ) {
    	System.out.println(request);
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody Employee request
    ) {
    	System.out.println("===>"+request.getPassword());
    	System.out.println("===>"+request.getEmailId());
        return ResponseEntity.ok(authService.authenticate(request));
    }
}
