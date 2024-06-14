package com.cognizant.service;

import java.util.List;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cognizant.entities.AuthenticationResponse;
import com.cognizant.entities.Employee;
import com.cognizant.entities.Token;
import com.cognizant.repositories.EmployeeRepository;
import com.cognizant.repositories.TokenRepository;

@Service
public class AuthenticationService {

    private final EmployeeRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    private final TokenRepository tokenRepository;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(EmployeeRepository repository,
                                 PasswordEncoder passwordEncoder,
                                 JwtService jwtService,
                                 TokenRepository tokenRepository,
                                 AuthenticationManager authenticationManager) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.tokenRepository = tokenRepository;
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationResponse register(Employee request) {

        // check if user already exist. if exist than authenticate the user
        if(repository.findByEmailId(request.getUsername()).isPresent()) {
            return new AuthenticationResponse(null, "User already exist", null);
        }

        Employee user = new Employee();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmailId(request.getEmailId());
        user.setContact(request.getContact());
        user.setGender(request.getGender());
        
        user.setPassword(passwordEncoder.encode(request.getPassword()));


        user.setRole(request.getRole().toUpperCase());

        user = repository.save(user);

        String jwt = jwtService.generateToken(user);

        saveUserToken(jwt, user);

        return new AuthenticationResponse(jwt, "User registration was successful", user);

    }

    public AuthenticationResponse authenticate(Employee request) {
    	try {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
    	}
    	catch(AuthenticationException e) {
            return new AuthenticationResponse(null, "Invalid User",null);
    	}

        Employee user = repository.findByEmailId(request.getUsername()).orElseThrow();
        String jwt = jwtService.generateToken(user);

        revokeAllTokenByUser(user);
        saveUserToken(jwt, user);

        return new AuthenticationResponse(jwt, "User login was successful",user);

    }
    private void revokeAllTokenByUser(Employee user) {
        List<Token> validTokens = tokenRepository.findAllTokensByUser(user.getEmployeeId());
        if(validTokens.isEmpty()) {
            return;
        }

        validTokens.forEach(t-> {
            t.setLoggedOut(true);
        });

        tokenRepository.saveAll(validTokens);
    }
    private void saveUserToken(String jwt, Employee user) {
        Token token = new Token();
        token.setToken(jwt);
        token.setLoggedOut(false);
        token.setUser(user);
        tokenRepository.save(token);
    }
}