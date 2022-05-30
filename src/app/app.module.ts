import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { EmpDataComponent } from './emp-data/emp-data.component';

import { ExtraModule } from './extra/extra.module';

@NgModule({
  declarations: [
    AppComponent,
    EmpDataComponent
  ],
  imports: [
    BrowserModule,
    ExtraModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
