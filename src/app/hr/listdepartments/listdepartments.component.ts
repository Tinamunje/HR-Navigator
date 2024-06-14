import { Component } from '@angular/core';
import { Departments } from '../../Dto/departments';
import { Router } from '@angular/router';
import { DepartmentserviceService } from './../../Service/departmentservice.service';

@Component({
  selector: 'app-listdepartments',
  templateUrl: './listdepartments.component.html',
  styleUrl: './listdepartments.component.css'
})
export class ListdepartmentsComponent {
  listofuser:any;
  users!:Departments;
  constructor(private router:Router,private departmentsservice:DepartmentserviceService) { 
    this.departmentsservice.getDepartments()
    .subscribe(data=>{
      this.listofuser=data;
      console.log(this.listofuser);
    });
  }
  
}
