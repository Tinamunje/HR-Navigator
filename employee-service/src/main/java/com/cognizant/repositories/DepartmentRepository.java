package com.cognizant.repositories;

import org.springframework.data.repository.CrudRepository;

import com.cognizant.entities.Department;

public interface DepartmentRepository extends CrudRepository<Department, Integer>{
	

}
