import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TextPipe } from '../text.pipe';



@NgModule({
  declarations: [
    TextPipe
  ],
  imports: [
    CommonModule
  ],
  exports:[TextPipe]
})
export class TestModule { }
