import { Component, OnInit } from '@angular/core';
import { Person } from 'src/model/person';

@Component({
  selector: 'app-person',
  templateUrl: './person.component.html',
  styleUrls: ['./person.component.css']
})
export class PersonComponent {

  constructor() { }

  submitForm(data:Person){
    console.log(data);
    console.table(data);
  }

}
