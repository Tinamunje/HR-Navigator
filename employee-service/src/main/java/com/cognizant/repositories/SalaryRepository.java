package com.cognizant.repositories;

import org.springframework.data.repository.CrudRepository;

import com.cognizant.entities.Salary;

public interface SalaryRepository extends CrudRepository<Salary, Integer> {

}
