package com.cognizant.service;

import java.util.List;

import com.cognizant.dto.DepartmentDto;



public interface DepartmentService{
	List<DepartmentDto> getAllDepartment();
	 DepartmentDto getDepartmentById(int DepartmentId);
    String insertNewDepartment(DepartmentDto departmentDTO);
    String deleteDepartmentById(int DepartmentId);
    String updateDepartmentDesc(int DepartmentId,String newDepartmentDesc);

}
