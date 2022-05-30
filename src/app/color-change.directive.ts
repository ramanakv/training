import { Directive, ElementRef, HostListener, Input } from '@angular/core';

@Directive({
  selector: '[changeColor]'
})
export class ColorChangeDirective {

  @Input('color') clr:string='green'
  constructor( private ele:ElementRef) { }

  @HostListener('mouseenter')
  changeColorToRed(){

    this.ele.nativeElement.style.backgroundColor=this.clr
    this.ele.nativeElement.style.color='white'
  }
  @HostListener('mouseleave')
  reverseColor(){
    this.ele.nativeElement.style.backgroundColor='white'
    this.ele.nativeElement.style.color='black'
  }


}
