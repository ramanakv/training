import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ColorChangeDirective } from './color-change.directive';
import { DirectivesComponent } from './directives/directives.component';
import { TextchangeDirective } from './textchange.directive';
import { SqrtPipe } from './sqrt.pipe';
import { TestModule } from './test/test.module';


@NgModule({
  declarations: [
    AppComponent,
    DirectivesComponent,
    TextchangeDirective,
    ColorChangeDirective,
    SqrtPipe
  ],
  imports: [
    BrowserModule,
    FormsModule,
    TestModule
  ],
  
  providers: [],
  bootstrap: [AppComponent]

})
export class AppModule { }
