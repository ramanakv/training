import { Component, OnInit } from '@angular/core';
import { Employee } from '../emp.model';

import { EmpService } from '../services/emp.service';

@Component({
  selector: 'emp-list',
  templateUrl: './emp-list.component.html',
  styles: [],
})
export class EmpListComponent implements OnInit {
  employees: Employee[] = [];
  selectedEmp: Employee|null = null
  constructor(private service: EmpService) {}

  obs:any
  
  ngOnInit(): void {
    this.loadData();
  }

  save(e: Employee) {
    this.service.saveEmployee(e).subscribe(
      (response) => {
        console.log(response);
        this.loadData();
      },
      (err) => console.log(err)
    );
  }

  delete(eid: number) {
    this.service.deleteEmployee(eid).subscribe(
      (response) => {
        console.log(response);
        this.loadData();
      },
      (err) => console.log(err)
    );
  }

  showDetails(eid: number) {
    this.service.getEmployee(eid).subscribe(
      (response) => {
        this.selectedEmp=response as Employee
      },
      (err) => console.log(err)
    );
  }

  loadData() {
 //   this.service.getAllEmployees().subscribe((data) => {
  //    this.employees = data;
   // });

this.obs=this.service.getAllEmployees();
  }
}
