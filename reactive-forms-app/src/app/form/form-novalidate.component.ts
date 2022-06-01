import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'form-no-validate',
  templateUrl: './form.novalidate.component.html',
  styles: []
})
export class FormNoValidateComponent {

  constructor() { }
  personForm = new FormGroup(
    {
    name: new FormControl(""),
    address: new FormControl(""),
    about: new FormControl(""),
    gender: new FormControl(""),
  }
  );

  submitForm(){
    console.log(this.personForm.value);
    console.table(this.personForm.value);
    this.personForm.setValue({name:'',address:'',about:'',gender:'M'})
  }

}
