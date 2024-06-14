import { Component } from '@angular/core';
import { Salary } from '../../Dto/salary';
import { SalaryserviceService } from './../../Service/salaryservice.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-deletesalary',
  templateUrl: './deletesalary.component.html',
  styleUrl: './deletesalary.component.css'
})
export class DeletesalaryComponent {
  tempUser:any;
  tempEmployeeId:any;
  submitted=false;
  constructor(private salaryservice:SalaryserviceService,private route: ActivatedRoute) {
   }
  onSubmit(){
    this.submitted=true;
    this.delete();
  }
  async delete(){
    console.log("delete called");
    console.log(this.tempEmployeeId);
    
    try {
      this.tempUser = await this.salaryservice.getSalariesById(this.tempEmployeeId).toPromise();
      console.log(this.tempUser);
    }
     catch (err) {
      alert("Employee Id is Invalid ");
      this.tempEmployeeId='';
    }
    
    this.salaryservice.deleteSalaries(this.tempUser)
    .subscribe(data=>console.log(data),
    error=>alert("Employee salary deleted successfully "));
    this.tempEmployeeId = ''; 
    
  }

}
