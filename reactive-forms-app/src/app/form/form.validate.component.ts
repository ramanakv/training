import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'form-validate',
  templateUrl: './form.validate.component.html',
  styles: []
})
export class FormValidateComponent {
  nameForm: FormGroup = new FormGroup(
    {
      firstName: new FormControl('', [
        Validators.required,
        Validators.minLength(5)
      ]),
      lastName: new FormControl('', [
        Validators.required,
        Validators.minLength(5)
      ]),
      description: new FormControl('', [
        Validators.minLength(15)
      ])
    }
  )

  submitForm() {
    console.log(this.nameForm.value);
    this.nameForm.setValue({firstName:'',lastName:'',description:''})
  }

  get f(){
    return this.nameForm.controls
  }


}


