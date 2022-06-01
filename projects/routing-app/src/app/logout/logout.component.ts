import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styles: [
  ]
})
export class LogoutComponent implements OnInit {

  constructor() { }

  message:string|null=null
  ngOnInit(): void {
    let name=localStorage.getItem('name');
    if(name==null){
      this.message= 'You are not loggedin'
    }
    else{
      localStorage.removeItem('name')
      this.message=name +' You are successfully loggedout'
    }
  }

}
