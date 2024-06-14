import { Component } from '@angular/core';
import { Salary } from '../../Dto/salary';
import { SalaryserviceService } from './../../Service/salaryservice.service';

@Component({
  selector: 'app-addsalary',
  templateUrl: './addsalary.component.html',
  styleUrl: './addsalary.component.css'
})
export class AddsalaryComponent {
  user:Salary=new Salary();
  submitted=false;
  constructor(private userservice:SalaryserviceService) { }

  onSubmit() {
    this.submitted = true;
    this.save();
  }
  
  save(){
    this.userservice.registerSalaries(this.user)
    .subscribe(data => console.log(data), error => console.log(error));
    this.user=new Salary();
  }
 
}
