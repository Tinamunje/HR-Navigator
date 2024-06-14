package com.cognizant.service;

import java.util.List;

import com.cognizant.dto.EmployeeDto;

public interface EmployeeService {
	List<EmployeeDto> getAllEmployees();
	 EmployeeDto getEmployeeById(int EmployeeId);
    String insertNewEmployee(EmployeeDto usersDTO);
    String deleteEmployeeById(int EmployeeId);
    String updateEmployeeRole(int Employee_Id,String newRole);
	
	

}
