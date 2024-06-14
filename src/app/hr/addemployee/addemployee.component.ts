import { Component } from '@angular/core';
import { User } from '../../Dto/user'
import { UserserviceService } from './../../Service/userservice.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-addemployee',
  templateUrl: './addemployee.component.html',
  styleUrl: './addemployee.component.css'
})
export class AddemployeeComponent {
  user:User=new User();
  submitted=false;
  constructor(private userservice:UserserviceService, private route: Router) { }

 
  onSubmit() {
    this.submitted = true;
    this.save();
    
  }
  save(){
    this.userservice.registerEmployee(this.user)
    .subscribe(data => console.log(data), error => console.log(error));
    this.user=new User();
  }
  
}
