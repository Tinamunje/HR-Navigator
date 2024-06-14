import { Component, OnInit } from '@angular/core';
import { User } from '../../Dto/user'
import { Router } from '@angular/router';
import { UserserviceService } from './../../Service/userservice.service';

@Component({
  selector: 'app-listemployee',
  templateUrl: './listemployee.component.html',
  styleUrl: './listemployee.component.css'
})
export class ListemployeeComponent {
  listofuser:any;
  users!:User;
  constructor(private router:Router,private userservice:UserserviceService) { 
    this.userservice.getEmployees()
    .subscribe(data=>{
      this.listofuser=data as User[];
      console.log(data);
    });
  } 
}
