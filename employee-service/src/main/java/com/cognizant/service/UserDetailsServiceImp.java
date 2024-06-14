package com.cognizant.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cognizant.repositories.EmployeeRepository;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

    private final EmployeeRepository repository;

    public UserDetailsServiceImp(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByEmailId(username)
                .orElseThrow(()-> new UsernameNotFoundException("User not found"));
    }
}
