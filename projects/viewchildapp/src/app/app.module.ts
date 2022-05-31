import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';

import { ViewchildComponent } from './viewchild/viewchild.component';
import { CounterComponent } from './viewchild/counter/counter.component';


@NgModule({
  declarations: [
    AppComponent, 
    ViewchildComponent,
    CounterComponent,  
  ],
  imports: [
    BrowserModule,
  ],
  providers: [
 
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
