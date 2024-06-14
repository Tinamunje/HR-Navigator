import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Salary } from '../Dto/salary';

@Injectable({
  providedIn: 'root'
})
export class SalaryserviceService {

  employeeId!:number;
  private retrieveSalariesURL = 'http://localhost:8080/api/salary/get';
  private registerSalariesURL='http://localhost:8080/api/salary';
  private deleteSalariesByIdURL='http://localhost:8080/api/salary';
  private updateSalariesURL='http://localhost:8080/api/salary';
  private retrieveSalariesByIdURL='http://localhost:8080/api/salary';
  constructor(private http:HttpClient) {
   }
   public getSalaries() {
    return this.http.get<Salary[]>(this.retrieveSalariesURL);
  }
  public getSalariesId(){
    return this.employeeId;
  }
  public registerSalaries(Salary: any) {
    return this.http.post<Salary>(this.registerSalariesURL, Salary);
  }
  public deleteSalaries(salary:any){
    return this.http.delete<Salary>(this.deleteSalariesByIdURL+"/"+salary.employeeId);
  }
  getSalariesById(employeeId: number): Observable<any> {
    const url=(`${this.retrieveSalariesByIdURL}/${employeeId}`);
    this.employeeId=employeeId;
    return this.http.get<Salary>(url)
  }
  public updateSalaries(salary:any,monthPay:any){
    return this.http.patch<Salary>(this.updateSalariesURL+"/"+salary.employeeId+"/"+monthPay,salary)
  } 
}
