package com.cognizant.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.dto.DepartmentDto;
import com.cognizant.entities.Department;
import com.cognizant.repositories.DepartmentRepository;

@Service("departmentServiceImpl")
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentRepository  departmentRepository;

	@Override
	public List<DepartmentDto> getAllDepartment() {
		Iterable<Department> departmentList=departmentRepository.findAll();
		List<DepartmentDto> departmentNewList=new ArrayList<DepartmentDto>();
		for(Department department:departmentList) {
			DepartmentDto departmentDTO=new DepartmentDto();
			departmentDTO.setDepartmentId(department.getDepartmentId());
			departmentDTO.setDepartmentName(department.getDepartmentName());
			departmentDTO.setDepartmentDesc(department.getDepartmentDesc());
			
			departmentNewList.add(departmentDTO);
		}
		return departmentNewList;
	}

	@Override
	public DepartmentDto getDepartmentById(int DepartmentId) {
		Optional<Department> departmentById= departmentRepository.findById(DepartmentId);
		DepartmentDto departmentDTO=new DepartmentDto();
				if(departmentById.isPresent()) {
					Department department=departmentById.get();
					departmentDTO.setDepartmentId(department.getDepartmentId());
					departmentDTO.setDepartmentName(department.getDepartmentName());
					departmentDTO.setDepartmentDesc(department.getDepartmentDesc());
				
				}
				return departmentDTO;
	}

	@Override
	public String insertNewDepartment(DepartmentDto departmentDTO) {
		Department department=new Department();
		department.setDepartmentId(departmentDTO.getDepartmentId());
		department.setDepartmentName(departmentDTO.getDepartmentName());
		department.setDepartmentDesc(departmentDTO.getDepartmentDesc());
		Department departmentCreated=departmentRepository.save(department);
		System.out.println(department.getDepartmentName());
		if(departmentCreated!=null)
			return "success";
		else
		return "fail";
	}

	@Override
	public String deleteDepartmentById(int DepartmentId) {
		departmentRepository.deleteById(DepartmentId);
		return "success";
	}


	@Override
	public String updateDepartmentDesc(int DepartmentId, String newDepartmentDesc) {
		Optional<Department> optionalOfDepartment=departmentRepository.findById(DepartmentId);
        Department departmentDescUpdated=null;
        if(optionalOfDepartment.isPresent()) {
            Department department=optionalOfDepartment.get();
            department.setDepartmentDesc(newDepartmentDesc);
            departmentDescUpdated=departmentRepository.save(department);
        }
        if(departmentDescUpdated!=null)
            return "success";
        else
        return "fail";
	}
	

	

}
