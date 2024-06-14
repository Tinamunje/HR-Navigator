import { Component } from '@angular/core';
import { Departments } from '../../Dto/departments'
import { DepartmentserviceService } from './../../Service/departmentservice.service'

@Component({
  selector: 'app-addingdepartments',
  templateUrl: './addingdepartments.component.html',
  styleUrl: './addingdepartments.component.css'
})
export class AddingdepartmentsComponent {
  user:Departments=new Departments();
  submitted=false;
  constructor(private departmentservice:DepartmentserviceService) { }

  onSubmit() {
    this.submitted = true;
    this.save();
  }
  
  save(){
    this.departmentservice.registerDepartments(this.user)
    .subscribe(data => console.log(data), error => console.log(error));
    this.user=new Departments();
  }

}
