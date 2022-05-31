import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms'
import { AppComponent } from './app.component';

import { FormNoValidateComponent } from './form/form-novalidate.component';
import { FormValidateComponent } from './form/form.validate.component';
import { SingleFieldComponent } from './single-field/single-field.component';



@NgModule({
  declarations: [
    AppComponent,
    FormValidateComponent,
    FormNoValidateComponent,
    SingleFieldComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
