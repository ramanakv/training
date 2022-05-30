import { Component, OnInit } from '@angular/core';
import { Person } from '../model/person';

@Component({
  selector: 'app-directive',
  templateUrl: './directives.component.html',
  styles: [
  ]
})
export class DirectivesComponent implements OnInit {

  constructor() { }

  persons:Person[]=[
    {
      name: 'Ramana',
      gender: 'M',
      address: 'Hyderabad',
    },
    {
      name: 'Sunita',
      gender: 'F',
      address: 'Mumbai',
    },
    {
      name: 'Ashok',
      gender: 'X',
      address: 'Delhi',
    }
  ]

show:boolean =true;

name:string='AnanD ReddY'
today:Date=new Date();

amount :number=32456.235

x:number=0

toggle(){
  this.show=!this.show
}

  ngOnInit(): void {
  }

}
