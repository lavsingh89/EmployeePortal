import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

export class Employee{
  constructor(    
    public  firstName:String,
    public  lastName:String,
    public  gender:String,
    public  dateOfBirth:Date,
    public  department:String,
  ) {}
}

@Injectable({
  providedIn: 'root'
})
export class HttpClientService {

  constructor(private httpClient:HttpClient) { }
  getEmployees()
  {
    console.log("Making Call");
    return this.httpClient.get<Employee[]>('http://localhost:8080/employees');
  }

  public createEmployee(employee) {
    return this.httpClient.post<Employee>("http://localhost:8080/employees", employee);
  }
}
