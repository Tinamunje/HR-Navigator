import { Component } from '@angular/core';

export class EmployeeDetails{
  employeeId: any;
  firstName: string;
  lastName: string;
  contact: any;
  emailId: string;
  role: any;
  gender: any;
  password: any;
}

@Component({
  selector: 'app-hr',
  templateUrl: './hr.component.html',
  styleUrl: './hr.component.css'
})
export class HrComponent {

  employeeId:number;

  emp:EmployeeDetails = new EmployeeDetails;

  logout(){
    localStorage.clear();
    alert("logout Successfull");
  }
}
