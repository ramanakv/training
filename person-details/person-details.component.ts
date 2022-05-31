import { Component, Input, EventEmitter, OnInit, Output } from '@angular/core';

import { Person } from '../model/person';

@Component({
  selector: 'person-details',
  templateUrl: './person-details.component.html',
  styles: [],
})
export class PersonDetailsComponent implements OnInit {
  @Input() person: Person = {} as Person;

  @Output() dismiss = new EventEmitter();

  constructor() {}

  ngOnInit(): void {}

  close() {
    this.dismiss.emit(`Details of ${this.person.name} close`);
  
  }
}
