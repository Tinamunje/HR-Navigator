package com.cognizant.service;

import java.util.List;

import com.cognizant.dto.SalaryDto;



public interface SalaryService{
     List<SalaryDto> getAllSalary();
	 SalaryDto getSalaryById(int EmployeeId);
   String insertNewSalary(SalaryDto salaryDTO);
   String deleteSalaryById(int EmployeeId);
   String updateSalary(int EmployeeId,Double newMonth_Pay);
}
