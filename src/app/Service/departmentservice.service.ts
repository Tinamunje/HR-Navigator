import { Injectable } from '@angular/core';
import { Departments } from '../Dto/departments';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DepartmentserviceService {
  departmentId!: number;
  private retrieveDepartmentsURL = 'http://localhost:8080/api/department/get';
  private registerDepartmentsURL='http://localhost:8080/api/department';
  private deleteDepartmentsByIdURL='http://localhost:8080/api/department';
  private updateDepartmentsURL='http://localhost:8080/api/department';
  private retrieveDepartmentsByIdURL='http://localhost:8080/api/department';
  constructor(private http:HttpClient) {
   }
   public getDepartments() {
    return this.http.get<Departments[]>(this.retrieveDepartmentsURL);
  }
  public geDepartmentsId(){
    return this.departmentId;
  }
  public registerDepartments(Departments: any) {
    return this.http.post<Departments>(this.registerDepartmentsURL, Departments);
  }
  public deleteDepartments(departments:any){
    return this.http.delete<Departments>(this.deleteDepartmentsByIdURL+"/"+departments.departmentId);
  }
  getDepartmentsById(departmentId: number): Observable<any> {
    const url=(`${this.retrieveDepartmentsByIdURL}/${departmentId}`);
    this.departmentId=departmentId;
    return this.http.get<Departments>(url)
  }
  public updateDepartments(departments:any,departmentDesc:any){
    return this.http.patch<Departments>(this.updateDepartmentsURL+"/"+departments.departmentId+"/"+departmentDesc,departments)
  } 
}
