import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styles: [
  ]
})
export class LoginComponent {

  name:string=''
  password:string=''
  message=''

login():void{
  if(this.name=='ramana' && this.password=='ramana'){
    this.message='Login success'
    localStorage.setItem("name","ramana")
  }
  else{
    this.message='Invalid login credentials'
  }
}

}
