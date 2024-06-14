package com.cognizant.service;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.dto.EmployeeDto;
import com.cognizant.entities.Employee;
import com.cognizant.repositories.EmployeeRepository;


@Service("employeeServiceImpl")
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeRepository employeeRepository;
	

	@Override
	public List<EmployeeDto> getAllEmployees() {
		
		Iterable<Employee> employeeList=employeeRepository.findAll();
		List<EmployeeDto> usersList=new ArrayList<EmployeeDto>();
		for(Employee employee:employeeList) {
			EmployeeDto usersDTO=new EmployeeDto();
			usersDTO.setEmployeeId(employee.getEmployeeId());
			usersDTO.setFirstName(employee.getFirstName());
			usersDTO.setLastName(employee.getLastName());
			usersDTO.setContact(employee.getContact());
			usersDTO.setEmailId(employee.getEmailId());
			usersDTO.setRole(employee.getRole());
		    usersDTO.setGender(employee.getGender());
			usersList.add(usersDTO);
		}
		return usersList;
	}

	@Override
	public EmployeeDto getEmployeeById(int EmployeeId) {
		Optional<Employee> employeeById= employeeRepository.findById(EmployeeId);
		EmployeeDto usersDTO=new EmployeeDto();
				if(employeeById.isPresent()) {
					Employee employee=employeeById.get();
					usersDTO.setEmployeeId(employee.getEmployeeId());
					usersDTO.setFirstName(employee.getFirstName());
					usersDTO.setLastName(employee.getLastName());
					usersDTO.setContact(employee.getContact());
					usersDTO.setEmailId(employee.getEmailId());
					usersDTO.setRole(employee.getRole());
				    usersDTO.setGender(employee.getGender());
				
				}
				return usersDTO;
	}

	@Override
	public String insertNewEmployee(EmployeeDto employeeDto) {
		
		
		Employee employee=new Employee();
		employee.setEmployeeId(employeeDto.getEmployeeId());
		employee.setFirstName(employeeDto.getFirstName());
		employee.setLastName(employeeDto.getLastName());
		employee.setContact(employeeDto.getContact());
		employee.setEmailId(employeeDto.getEmailId());
		employee.setRole(employeeDto.getRole());
		employee.setGender(employeeDto.getGender());
		Employee employeeCreated=employeeRepository.save(employee);
		if(employeeCreated!=null)
			return "success";
		else
		return "fail";
	}

	@Override
	public String deleteEmployeeById(int EmployeeId) {
		employeeRepository.deleteById(EmployeeId);
		return "success";
	}
	@Override
	public String updateEmployeeRole(int Employee_Id,String newRole) {
	       
        Optional<Employee> optionalOfEmployee=employeeRepository.findById(Employee_Id);
        Employee employeeUpdated=null;
        if(optionalOfEmployee.isPresent()) {
            Employee employee=optionalOfEmployee.get();
           employee.setRole(newRole);
        employeeUpdated=employeeRepository.save(employee);
        }
        if(employeeUpdated!=null)
            return "success";
        else
        return "fail";
    }

}
