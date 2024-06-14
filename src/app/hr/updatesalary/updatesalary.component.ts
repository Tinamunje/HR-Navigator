import { Component } from '@angular/core';
import { Salary } from '../../Dto/salary';
import { SalaryserviceService } from './../../Service/salaryservice.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-updatesalary',
  templateUrl: './updatesalary.component.html',
  styleUrl: './updatesalary.component.css'
})
export class UpdatesalaryComponent {
  usersTemp:any;
  salTemp:any;
  updateSal:any;
  submitted = false;
  errorMessage:string="";
  errorStatus:boolean=false;
users!:Salary[];
  constructor(private userservice:SalaryserviceService,private route: ActivatedRoute) {

   }

   onSubmit() {
    this.submitted = true;
    this.update();
  }

async update() {
  console.log("update called");

  try {
    this.usersTemp = await this.userservice.getSalariesById(this.updateSal).toPromise();
    console.log(this.usersTemp);
  } 
  catch (err) {
   alert("EmployeeId is Invalid!")
   this.updateSal = ''; 
   this.salTemp = ''; 
  }

this.userservice.updateSalaries(this.usersTemp,this.salTemp)
  .subscribe((data: any) => {console.log(data)}, (error: { error: { message: string; }; }) =>{console.log(error);
    this.errorMessage=error.error.message;
  });
      alert("Employee data updated successfully")
      this.updateSal = '';
      this.salTemp = '';
}
    
  
  
}
