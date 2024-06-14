import { Component } from '@angular/core';
import { User } from '../../Dto/user';
import { UserserviceService } from './../../Service/userservice.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-updateemployee',
  templateUrl: './updateemployee.component.html',
  styleUrl: './updateemployee.component.css'
})
export class UpdateemployeeComponent {
  usersTemp:any;
  roleTemp:any;
  updateEmp:any;
  submitted = false;
  errorMessage:string="";
  errorStatus:boolean=false;
  users!:User[];
  constructor(private userservice:UserserviceService,private route: ActivatedRoute) {
  }
 
  onSubmit() {
    this.submitted = true;
    console.log(this.usersTemp)
     this.update();
  }

 async update() {
    console.log("update called");
  
    try {
      this.usersTemp = await this.userservice.getEmployeeById(this.updateEmp).toPromise();
      console.log(this.usersTemp);
    } 
    catch (err) {
     alert("EmployeeId is Invalid!")
     this.updateEmp = ''; 
     this.roleTemp = ''; 
    }

  this.userservice.updateEmployee(this.usersTemp,this.roleTemp)
    .subscribe((data: any) => {console.log(data)}, (error: { error: { message: string; }; }) =>{console.log(error);
      this.errorMessage=error.error.message;
    });
        alert("Employee data updated successfully")
        this.updateEmp = '';
        this.roleTemp = '';
}
}
