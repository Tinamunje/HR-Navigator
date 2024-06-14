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
import com.cognizant.dto.SalaryDto;
import com.cognizant.service.SalaryService;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200/")
public class SalaryController {
	@Autowired
	private SalaryService salaryService;
	@GetMapping("/salary/get")
	public ResponseEntity<?> handleGetAllSalary(){
		List<SalaryDto> responseList=salaryService.getAllSalary();
		ResponseEntity<List<SalaryDto>> responseEntity=null;
		if(!responseList.isEmpty()) {
			responseEntity=new ResponseEntity<List<SalaryDto>>(responseList,HttpStatus.OK);
		}else {
			responseEntity=new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
		
		@GetMapping("/salary/{EmployeeId}")
		public ResponseEntity<?> getSalaryById(@PathVariable("EmployeeId")int EmployeeId){
			SalaryDto response=salaryService.getSalaryById(EmployeeId);
			ResponseEntity<SalaryDto> responseEntity=null;
			if(response.getEmployeeId()!=0) {
				responseEntity=new ResponseEntity<SalaryDto>(response,HttpStatus.OK);
			}else {
				responseEntity=new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			return responseEntity;
		}
		@PostMapping("/salary")
		public ResponseEntity<?> insertSalary(@RequestBody SalaryDto SalaryRequest){
			String result=salaryService.insertNewSalary(SalaryRequest);
			if(result.equals("success")) {
				return new ResponseEntity<String>("New Salary Added",HttpStatus.CREATED);
			}else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		}
			@DeleteMapping("/salary/{EmployeeId}")
			public ResponseEntity<?> deleteSalaryById(@PathVariable("EmployeeId")int EmployeeId){
				String result=salaryService.deleteSalaryById(EmployeeId);
				if(result.equals("success")) {
					return new ResponseEntity<String>("Deleted Successfully",HttpStatus.OK);
				}else {
					return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
				}
			}
			@PatchMapping("/salary/{Employee_Id}/{newMonth_Pay}")
			public ResponseEntity<?> handleUpdateSalary(@PathVariable("Employee_Id")int Employee_Id,@PathVariable("newMonth_Pay")Double newMonth_Pay){
			        String result=salaryService.updateSalary(Employee_Id, newMonth_Pay);
			        if(result.equals("success")) {
			            return new ResponseEntity<String>("Updated Successfully",HttpStatus.ACCEPTED);
			        }else {
			            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
			        }
			    }
}
