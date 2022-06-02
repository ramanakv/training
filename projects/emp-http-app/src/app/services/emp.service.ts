import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from '../emp.model';

@Injectable({
  providedIn: 'root',
})
export class EmpService {
  constructor(private http: HttpClient) {}

  baseUrl: string = 'http://localhost:3000/employees';

  getAllEmployees(): Observable<any> {
    return this.http.get(this.baseUrl);
  }

  getEmployee(id:number) {
    return this.http.get(`${this.baseUrl}/${id}`);
  }
  
  saveEmployee(e: Employee) {
    return this.http.post(this.baseUrl, e);
  }

  deleteEmployee(id:number) {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }


}
