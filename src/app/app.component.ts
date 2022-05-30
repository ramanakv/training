import { Component } from '@angular/core';
import { Person } from './model/person';

@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  person: Person = {
    name: 'Ramana Reddy',
    gender: 'Male',
    address: 'Hyderabad',
  };
}
