import { Component } from '@angular/core';
import { Departments } from '../../Dto/departments'
import { DepartmentserviceService } from './../../Service/departmentservice.service'
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-deletedepartments',
  templateUrl: './deletedepartments.component.html',
  styleUrl: './deletedepartments.component.css'
})
export class DeletedepartmentsComponent {
  tempUser:any;
  tempDeptId:any;
  submitted=false;
  constructor(private departmentservice:DepartmentserviceService,private route: ActivatedRoute) {

   }
  onSubmit(){
    this.submitted=true;
    this.delete();
  }
 
  async delete(){
    console.log("delete called");
    console.log(this.tempDeptId);
    
    try {
      this.tempUser = await this.departmentservice.getDepartmentsById(this.tempDeptId).toPromise();
      console.log(this.tempUser);
    }
     catch (err) {
      alert("Department Id is Invalid ");
      this.tempDeptId='';
    }
    
    this.departmentservice.deleteDepartments(this.tempUser)
    .subscribe(data=>console.log(data),
    error=>alert("Department data deleted successfully "));
    this.tempDeptId = ''; 
    
  }
}
