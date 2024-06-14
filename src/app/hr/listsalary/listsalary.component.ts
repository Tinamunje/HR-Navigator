import { Component } from '@angular/core';
import { Salary } from '../../Dto/salary';
import { Router } from '@angular/router';
import { SalaryserviceService } from './../../Service/salaryservice.service';

@Component({
  selector: 'app-listsalary',
  templateUrl: './listsalary.component.html',
  styleUrl: './listsalary.component.css'
})
export class ListsalaryComponent {
  listofuser:any;
  users!:Salary;
  constructor(private router:Router,private salaryservice:SalaryserviceService) { 
    this.salaryservice.getSalaries()
    .subscribe(data=>{
      this.listofuser=data;
      console.log(this.listofuser);
    });
  }
    
}
