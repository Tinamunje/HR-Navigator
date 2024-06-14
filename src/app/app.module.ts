import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {FormsModule, FormGroup} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { SignupComponent } from './signup/signup.component';
import { HrComponent } from './hr/hr.component';
import { RouterModule, Routes } from '@angular/router';
import { AddemployeeComponent } from './hr/addemployee/addemployee.component';
import { AddingdepartmentsComponent } from './hr/addingdepartments/addingdepartments.component';
import { AddsalaryComponent } from './hr/addsalary/addsalary.component';
import { DeletedepartmentsComponent } from './hr/deletedepartments/deletedepartments.component';
import { DeleteemployeeComponent } from './hr/deleteemployee/deleteemployee.component';
import { DeletesalaryComponent } from './hr/deletesalary/deletesalary.component';
import { ManageEmployeeComponent } from './hr/manage-employee/manage-employee.component';
import { ManageDepartmentComponent } from './hr/manage-department/manage-department.component';
import { ManageSalaryComponent } from './hr/manage-salary/manage-salary.component';
import { ListdepartmentsComponent } from './hr/listdepartments/listdepartments.component';
import { ListemployeeComponent } from './hr/listemployee/listemployee.component';
import { ListsalaryComponent } from './hr/listsalary/listsalary.component';
import { UpdatedepartmentsComponent } from './hr/updatedepartments/updatedepartments.component';
import { UpdatesalaryComponent } from './hr/updatesalary/updatesalary.component';
import { UpdateemployeeComponent } from './hr/updateemployee/updateemployee.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    SignupComponent,
    HrComponent,
    AddemployeeComponent,
    AddingdepartmentsComponent,
    AddsalaryComponent,
    DeletedepartmentsComponent,
    DeleteemployeeComponent,
    DeletesalaryComponent,
    ManageEmployeeComponent,
    ManageDepartmentComponent,
    ManageSalaryComponent,
    ListdepartmentsComponent,
    ListemployeeComponent,
    ListsalaryComponent,
    UpdatedepartmentsComponent,
    UpdateemployeeComponent,
    UpdatesalaryComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    HttpClientModule,
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
