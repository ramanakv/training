import { Component, OnInit } from '@angular/core';
import { Employee } from 'src/employee';

import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-emp-list',
  templateUrl: './emp-list.component.html',
  styleUrls: ['./emp-list.component.css']
})
export class EmpListComponent implements OnInit {

  constructor(private empService:EmployeeService) { }


  empList:Employee[] = [];
  

  ngOnInit() {
     this.empList = this.empService.getAllEmployees(); 
  }

}
