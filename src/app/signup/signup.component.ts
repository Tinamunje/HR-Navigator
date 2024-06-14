import { Component } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { UserserviceService } from '../Service/userservice.service';

export class Employee{
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
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.css'
})
export class SignupComponent {

  contactForm = new FormGroup({
    password : new FormControl('', [Validators.required]),
    email : new FormControl('', [Validators.required, Validators.email]),
    mobileNo : new FormControl('', [Validators.required]),
    firstname : new FormControl('', [Validators.required]),
    lastname : new FormControl('', [Validators.required]),
    gender : new FormControl('', [Validators.required])
  })

  emp: Employee = new Employee;

  constructor(private service: UserserviceService){}

  onSelectRole(event :Event){
    this.emp.role = (event.target as HTMLSelectElement).value;
  }

  registerUser(){
    if(this.contactForm.valid){
      this.service.registerEmployee(this.emp).subscribe(data=>{
        console.log(this.emp);
        alert("Registered Successfully");
      });
    }
    else{
      alert("Please enter the details")
    }
  }
}
