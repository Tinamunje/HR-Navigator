package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.dto.EmployeeDto;
import com.cognizant.service.EmployeeService;
@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api")

public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	@GetMapping("/employees/get")
	public ResponseEntity<?> handleGetAllEmployees(){
		List<EmployeeDto> responseList=employeeService.getAllEmployees();
		ResponseEntity<List<EmployeeDto>> responseEntity=null;
		if(!responseList.isEmpty()) {
			responseEntity=new ResponseEntity<List<EmployeeDto>>(responseList,HttpStatus.OK);
		}else {
			responseEntity=new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	@GetMapping("/employees/{EmployeeId}")
	public ResponseEntity<?> getEmployeeById(@PathVariable("EmployeeId")int EmployeeId){
		EmployeeDto response=employeeService.getEmployeeById(EmployeeId);
		ResponseEntity<EmployeeDto> responseEntity=null;
		if(response.getEmployeeId()!=0) {
			responseEntity=new ResponseEntity<EmployeeDto>(response,HttpStatus.OK);
		}else {
			responseEntity=new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	
	@PostMapping("/employees")
	public ResponseEntity<?> insertEmployee(@RequestBody EmployeeDto employeeRequest){
				String result=employeeService.insertNewEmployee(employeeRequest);
		if(result.equals("success")) {
			return new ResponseEntity<String>("Employee is created",HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	@DeleteMapping("/employees/{EmployeeId}")
	public ResponseEntity<?> deleteEmployeeById(@PathVariable("EmployeeId")int EmployeeId){
		String result=employeeService.deleteEmployeeById(EmployeeId);
		if(result.equals("success")) {
			return new ResponseEntity<String>("Deleted Successfully",HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PatchMapping("/employees/{Employee_Id}/{newRole}")
	public ResponseEntity<?> handleUpdateEmployeeRole(@PathVariable("Employee_Id")int Employee_Id,@PathVariable("newRole")String newRole){
		System.out.println(newRole);
		System.out.println(Employee_Id);
		
	        String result=employeeService.updateEmployeeRole(Employee_Id, newRole);
	        if(result.equals("success")) {
	            return new ResponseEntity<String>("Employee New Role is Updated",HttpStatus.ACCEPTED);
	        }else {
	            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
	        }
	    }
	
}
