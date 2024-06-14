import { Component ,OnInit} from '@angular/core';
import { User } from '../../Dto/user'
import { UserserviceService } from './../../Service/userservice.service'
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-deleteemployee',
  templateUrl: './deleteemployee.component.html',
  styleUrl: './deleteemployee.component.css'
})
export class DeleteemployeeComponent implements OnInit {
  tempUser:any;
  tempEmployeeId:any;
  submitted=false;
  constructor(public userservice:UserserviceService,public route: ActivatedRoute, public router: Router) {

   }

  ngOnInit(): void {
   }

  onSubmit(){
    this.submitted=true;
    console.log(this.tempEmployeeId);
    this.delete();

  }

  async delete(){
    console.log("delete called");
    console.log(this.tempEmployeeId);
    
    try {
      this.tempUser = await this.userservice.getEmployeeById(this.tempEmployeeId).toPromise();
      console.log(this.tempUser);
    }
     catch (err) {
      alert("Employee Id is Invalid ");
      this.tempEmployeeId='';
    }
    
    this.userservice.deleteEmployee(this.tempUser)
    .subscribe(data=>console.log(data),
    error=>alert("Employee deleted successfully "));
    this.tempEmployeeId = ''; 
    
  }
 

}
