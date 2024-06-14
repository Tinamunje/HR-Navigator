import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../Dto/user';

@Injectable({
  providedIn: 'root'
})
export class UserserviceService {
  employeeId!:number;
  private retrieveEmployeesURL = 'http://localhost:8080/api/employees/get';
  private registerEmployeesURL='http://localhost:8080/register';
  private deleteEmployeeByIdURL='http://localhost:8080/api/employees';
  private updateEmployeeURL='http://localhost:8080/api/employees';
  private retrieveEmployeeByIdURL='http://localhost:8080/api/employees';
  constructor(private http:HttpClient) {
   }
   public login(emailId,password) {
    return this.http.post('http://localhost:8080/login',{emailId,password});
  }
  public registerEmployee(User: any) {
    return this.http.post<User>(this.registerEmployeesURL, User);
  }
  public getEmployees() {
    return this.http.get<User[]>(this.retrieveEmployeesURL);
  }
  public deleteEmployee(user:any){
    return this.http.delete<User>(this.deleteEmployeeByIdURL+"/"+user.employeeId);
  }
 
  public getEmployeeId(){
    return this.employeeId;
  }
   getEmployeeById(employeeId: number): Observable<any> {
    const url=(`${this.retrieveEmployeeByIdURL}/${employeeId}`);
    this.employeeId=employeeId;
    return this.http.get<User>(url)
  }
  public updateEmployee(user:any,role:any){
  
    return this.http.patch<User>(this.updateEmployeeURL+"/"+user.employeeId+"/"+role,user)
  } 
}
