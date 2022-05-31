import { Component, OnInit } from '@angular/core';
import { Person } from '../model/person';

@Component({
  selector: 'person-list',
  templateUrl: './person-list.component.html',
  styleUrls: ['./person-list.component.css'],
})
export class PersonListComponent implements OnInit {
  persons: Person[] = [
    {
      name: 'Ramana',
      gender: 'Male',
      address: 'Hyderabad',
    },
    {
      name: 'Sunita',
      gender: 'Female',
      address: 'Mumbai',
    },
    {
      name: 'Ashok',
      gender: 'Male',
      address: 'Delhi',
    },
  ];

  selectedPerson: Person | undefined = undefined;

  constructor() {}

  ngOnInit(): void {}
  hideChild(message:string) {
    this.selectedPerson = undefined;
    console.log(message)
  }

  selectPerson(x: number) {
    this.selectedPerson = this.persons[x];
  }
}
