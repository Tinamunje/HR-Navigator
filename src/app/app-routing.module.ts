import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { HrComponent } from './hr/hr.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { AddemployeeComponent } from './hr/addemployee/addemployee.component';
import { AddingdepartmentsComponent } from './hr/addingdepartments/addingdepartments.component';
import { AddsalaryComponent } from './hr/addsalary/addsalary.component';
import { DeletedepartmentsComponent } from './hr/deletedepartments/deletedepartments.component';
import { DeleteemployeeComponent } from './hr/deleteemployee/deleteemployee.component';
import { DeletesalaryComponent } from './hr/deletesalary/deletesalary.component';
import { ManageEmployeeComponent } from './hr/manage-employee/manage-employee.component';
import { ManageDepartmentComponent } from './hr/manage-department/manage-department.component';
import { ManageSalaryComponent } from './hr/manage-salary/manage-salary.component';
import { ListemployeeComponent } from './hr/listemployee/listemployee.component';
import { ListdepartmentsComponent } from './hr/listdepartments/listdepartments.component';
import { ListsalaryComponent } from './hr/listsalary/listsalary.component';
import { UpdateemployeeComponent } from './hr/updateemployee/updateemployee.component';
import { UpdatedepartmentsComponent } from './hr/updatedepartments/updatedepartments.component';
import { UpdatesalaryComponent } from './hr/updatesalary/updatesalary.component';
import { authGuard } from './auth.guard';

const routes: Routes = [
  {path: "", component : HomeComponent},
  {path: "home", component: HomeComponent},
  {path: "login", component: LoginComponent},
  {path: "signup", component: SignupComponent},
  {path: "signup/login", component: SignupComponent},
  {path: "login/signup", component: LoginComponent},
  {path: "hr", component :HrComponent, canActivate : [authGuard]},
  {path: "hr/manageEmp/addEmp", component :AddemployeeComponent, canActivate : [authGuard]},
  {path: "hr/manageDep/addDep", component:AddingdepartmentsComponent, canActivate : [authGuard]},
  {path: "hr/manageSalary/addSalary", component: AddsalaryComponent, canActivate : [authGuard]},
  {path: "hr/manageDep/deleteDep", component: DeletedepartmentsComponent, canActivate : [authGuard]},
  {path: "hr/manageEmp/deleteEmp", component: DeleteemployeeComponent, canActivate : [authGuard]},
  {path: "hr/manageSalary/deleteSalary", component: DeletesalaryComponent, canActivate : [authGuard]},
  {path: "hr/manageEmp", component: ManageEmployeeComponent, canActivate : [authGuard]},
  {path: "hr/manageDep", component: ManageDepartmentComponent, canActivate : [authGuard]},
  {path: "hr/manageSalary", component: ManageSalaryComponent, canActivate : [authGuard]},
  {path: "hr/manageEmp/listEmp", component: ListemployeeComponent, canActivate : [authGuard]},
  {path: "hr/manageEmp/deleteEmp/listEmp", component: ListemployeeComponent, canActivate : [authGuard]},
  {path: "hr/manageDep/listDep", component: ListdepartmentsComponent, canActivate : [authGuard]},
  {path: "hr/manageSalary/listSalary", component: ListsalaryComponent, canActivate : [authGuard]},
  {path: "hr/manageEmp/updateEmp", component: UpdateemployeeComponent, canActivate : [authGuard]},
  {path: "hr/manageDep/updateDep", component: UpdatedepartmentsComponent, canActivate : [authGuard]},
  {path: "hr/manageSalary/updateSalary", component: UpdatesalaryComponent, canActivate : [authGuard]},
  {path: "listDep", component: ListdepartmentsComponent, canActivate : [authGuard]}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
