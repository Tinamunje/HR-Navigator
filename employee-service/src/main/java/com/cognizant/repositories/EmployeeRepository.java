package com.cognizant.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.cognizant.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee,Integer>{
	
	Optional<Employee> findByEmailId(String emailId);
}
