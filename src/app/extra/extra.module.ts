import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Comp1Component } from './comp1/comp1.component';


@NgModule({
  declarations: [
    Comp1Component
  ],
  imports: [
    CommonModule
  ],
  exports:[
    Comp1Component
  ]
})
export class ExtraModule { }
