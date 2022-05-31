import { Injectable } from '@angular/core';
import { Employee } from 'src/employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor() { }

  employees: Employee[] = [
    { empid: 100, name: "Alok Singh", salary: 9000 },
    { empid: 200, name: "Armugam", salary: 15000 },
    { empid: 300, name: "Kishore Kumar", salary: 19000 },
    { empid: 400, name: "Anil Malhotra", salary: 29000 },
    { empid: 500, name: "SriLakshmi", salary: 39000 }
  ]

  getAllEmployees(): Employee[] {
    return this.employees;
  }

  getEmployee(id: number): Employee|null {
    for (let e of this.employees) {
      if (e.empid == id)
        return e;
    }
    return null;
  }

  


}
