import { Component } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserserviceService } from '../Service/userservice.service';
export class UserLogin {
  emailId:string;
  password:string;
 
  constructor(){
    this.emailId='';
    this.password='';
  }
}
 
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
 
 
  ngOnInit():void{
  }
 
  //validations
  contactForm = new FormGroup({
    password : new FormControl('', [Validators.required]),
    email : new FormControl('', [Validators.required, Validators.email])
  })
 
  user: UserLogin;
 
  constructor(private service: UserserviceService, private route: Router) {
    this.user = new UserLogin;
  }

  loginUser(){

    console.log(this.user.emailId,"password", this.user.password)
    this.service.login(this.user.emailId,this.user.password).subscribe(
        (data: any) => {
        console.log(data);
        if(data.message === 'User login was successful'){
                  if(['EMPLOYEE'].includes(data.employee.role)){
                      localStorage.setItem("id",data.id);
                      localStorage.setItem("role",data.employee.role);
                      localStorage.setItem("token",data.token);
                      alert("Login successful");
                      this.route.navigateByUrl('listDep')
                  }
                  else if(data.employee.role === 'HR'){
                      alert("Login successful");
                      this.route.navigateByUrl('hr');
                  }
        }
          else {
              alert("Invalid Credentials");
          }

      }
    )
    }
  }
