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
import com.cognizant.dto.DepartmentDto;
import com.cognizant.service.DepartmentService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	@GetMapping("/department/get")
	public ResponseEntity<?> handleGetAllDepartment(){
		List<DepartmentDto> responseList=departmentService.getAllDepartment();
		ResponseEntity<List<DepartmentDto>> responseEntity=null;
		if(!responseList.isEmpty()) {
			responseEntity=new ResponseEntity<List<DepartmentDto>>(responseList,HttpStatus.OK);
		}else {
			responseEntity=new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	@GetMapping("department/{DepartmentId}")
	public ResponseEntity<?> getDepartmentById(@PathVariable("DepartmentId")int DepartmentId){
		DepartmentDto response=departmentService.getDepartmentById(DepartmentId);
		ResponseEntity<DepartmentDto> responseEntity=null;
		if(response.getDepartmentId()!=0) {
			responseEntity=new ResponseEntity<DepartmentDto>(response,HttpStatus.OK);
		}else {
			responseEntity=new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	@PostMapping("/department")
	public ResponseEntity<?> insertDepartment(@RequestBody DepartmentDto DepartmentRequest){
		String result=departmentService.insertNewDepartment(DepartmentRequest);
		if(result.equals("success")) {
			return new ResponseEntity<String>("Inserted Successfully",HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	@DeleteMapping("/department/{DepartmentId}")
	public ResponseEntity<?> deleteDepartmentById(@PathVariable("DepartmentId")int DepartmentId){
		String result=departmentService.deleteDepartmentById(DepartmentId);
		if(result.equals("success")) {
			return new ResponseEntity<String>("Deleted Successfully",HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	@PatchMapping("/department/{Department_Id}/{newDepartmentDesc}")
	public ResponseEntity<?> handleUpdateDepartmentDesc(@PathVariable("Department_Id")int Department_Id,@PathVariable("newDepartmentDesc")String newDepartmentDesc){
	        String result=departmentService.updateDepartmentDesc(Department_Id, newDepartmentDesc);
	        if(result.equals("success")) {
	            return new ResponseEntity<String>("Updated Successfully",HttpStatus.ACCEPTED);
	        }else {
	            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
	        }
	    }
}
