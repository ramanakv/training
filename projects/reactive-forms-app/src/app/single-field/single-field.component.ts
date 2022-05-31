import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'single-field',
  templateUrl: './single-field.component.html',
  styleUrls: ['./single-field.component.css']
})
export class SingleFieldComponent implements OnInit {

firstName=new FormControl("Ramana")
lastName=new FormControl("Reddy")

  constructor() { }

  ngOnInit(): void {
  }


  save(){
    
  }
}
