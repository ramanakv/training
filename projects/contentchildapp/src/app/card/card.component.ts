import { Component, ContentChild, ContentChildren, ElementRef, Renderer2,  ViewChild } from '@angular/core';


@Component({
  selector: 'card',
  template: `
    <div class="card">
      <ng-content select="header"></ng-content>
      <ng-content select="content"></ng-content>
      <ng-content select="footer"></ng-content>
    </div>  
  `,
  styles: [
    ` .card { min-width: 280px;  margin: 5px;  float:left  } 
    `
  ]
})

export class CardComponent {

  @ContentChild("header") cardContentHeader: ElementRef={} as ElementRef;
  @ContentChild("content") cardContentContent: ElementRef={} as ElementRef;

  constructor(private renderor:Renderer2) {  }

  
  ngAfterContentInit() {

    this.renderor.setStyle(this.cardContentHeader.nativeElement,"font-size","30px")

   this.cardContentContent.nativeElement.innerHTML="<h1>Test</h1>"
      }


}