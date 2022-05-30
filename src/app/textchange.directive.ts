import { Directive, ElementRef } from '@angular/core';

@Directive({
  selector: '[TC]'
})
export class TextchangeDirective {

  constructor(private ele:ElementRef) { 

    this.ele.nativeElement.innerText='This is changed value'
    this.ele.nativeElement.style.color='red'
  }

}
