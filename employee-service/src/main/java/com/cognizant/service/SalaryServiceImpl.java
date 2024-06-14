package com.cognizant.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.dto.SalaryDto;
import com.cognizant.entities.Salary;
import com.cognizant.repositories.SalaryRepository;

@Service("salaryServiceImpl")
public class SalaryServiceImpl implements SalaryService{
	@Autowired
	private SalaryRepository salaryRepository;

	@Override
	public List<SalaryDto> getAllSalary() {
		Iterable<Salary> salaryList=salaryRepository.findAll();
		List<SalaryDto> salaryNewList=new ArrayList<SalaryDto>();
		for(Salary salary:salaryList) {
			SalaryDto salaryDTO=new SalaryDto();
			salaryDTO.setEmployeeId(salary.getEmployeeId());
			salaryDTO.setAccountNo(salary.getAccountNo());
			salaryDTO.setMonthPay(salary.getMonthPay());
			
			salaryNewList.add(salaryDTO);
		}
		return salaryNewList;
	}

	@Override
	public SalaryDto getSalaryById(int EmployeeId) {
		Optional<Salary> salaryById= salaryRepository.findById(EmployeeId);
		SalaryDto salaryDTO=new SalaryDto();
				if(salaryById.isPresent()) {
					Salary salary=salaryById.get();
					salaryDTO.setEmployeeId(salary.getEmployeeId());
					salaryDTO.setAccountNo(salary.getAccountNo());
					salaryDTO.setMonthPay(salary.getMonthPay());
				
				}
				return salaryDTO;
	}

	@Override
	public String insertNewSalary(SalaryDto salaryDTO) {
		Salary salary=new Salary();
		salary.setEmployeeId(salaryDTO.getEmployeeId());
		salary.setAccountNo(salaryDTO.getAccountNo());
		salary.setMonthPay(salaryDTO.getMonthPay());
		Salary salaryCreated=salaryRepository.save(salary);
		if(salaryCreated!=null)
			return "success";
		else
		return "fail";
	}

	@Override
	public String deleteSalaryById(int EmployeeId) {
		salaryRepository.deleteById(EmployeeId);
		return "success";
	}

	@Override
	public String updateSalary(int EmployeeId, Double newMonth_Pay) {
		Optional<Salary> optionalOfSalary=salaryRepository.findById(EmployeeId);
		Salary salaryUpdated=null;
        if(optionalOfSalary.isPresent()) {
        	Salary salary=optionalOfSalary.get();
        	salary.setMonthPay(newMonth_Pay);
            salaryUpdated=salaryRepository.save(salary);
        }
        if(salaryUpdated!=null)
            return "success";
        else
        return "fail";
	
	}
	
	


}
