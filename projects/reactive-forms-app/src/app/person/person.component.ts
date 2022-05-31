import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-person',
  templateUrl: './person.component.html',
  styleUrls: ['./person.component.css']
})
export class PersonComponent {

  constructor() { }
  personForm = new FormGroup({
    name: new FormControl(""),
    address: new FormControl(""),
    about: new FormControl(""),
    gender: new FormControl(""),
  });

  submitForm(){
    console.log(this.personForm.value);
    console.table(this.personForm.value);
  }

}
