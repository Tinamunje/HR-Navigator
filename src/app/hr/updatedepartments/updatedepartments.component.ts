import { Component } from '@angular/core';
import { Departments } from '../../Dto/departments';
import { ActivatedRoute } from '@angular/router';
import { DepartmentserviceService } from './../../Service/departmentservice.service';

@Component({
  selector: 'app-updatedepartments',
  templateUrl: './updatedepartments.component.html',
  styleUrl: './updatedepartments.component.css'
})
export class UpdatedepartmentsComponent {

  deptTemp:any;
  descTemp:any;
  updateDept:any
  submitted = false;
  errorMessage:string="";
  errorStatus:boolean=false;
users!:Departments[];
  constructor(private departmentservice:DepartmentserviceService,private route: ActivatedRoute) {
  
   }

     
  onSubmit() {
    this.submitted = true;
    this.update();
  }

async update() {
  console.log("update called");

  try {
    this.deptTemp = await this.departmentservice.getDepartmentsById(this.updateDept).toPromise();
    console.log(this.deptTemp);
  } 
  catch (err) {
   alert("Department Id is Invalid!")
   this.updateDept = ''; 
   this.descTemp = ''; 
  }

this.departmentservice.updateDepartments(this.deptTemp,this.descTemp)
  .subscribe((data: any) => {console.log(data)}, (error: { error: { message: string; }; }) =>{console.log(error);
    this.errorMessage=error.error.message;
  });
      alert("Department description updated successfully")
      this.updateDept = '';
      this.descTemp = '';
}
    

}
