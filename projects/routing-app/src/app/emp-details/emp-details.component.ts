import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from 'src/employee';

import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-emp-details',
  templateUrl: './emp-details.component.html',
  styleUrls: ['./emp-details.component.css'],
})
export class EmpDetailsComponent implements OnInit {
  constructor(
    private empService: EmployeeService,
    private router: ActivatedRoute,
    private route: Router
  ) {}

  emp: Employee|null=null
  selectedId: number = 0;

  ngOnInit() {
    this.router.paramMap.subscribe((params) => {
      let id = params.get('eid');
      if (id != null) this.selectedId = parseInt(id);

      this.emp=this.empService.getEmployee(this.selectedId)
      
    });
  }

  goBack(): void {
    this.route.navigate(['/emplist']);
  }
}
