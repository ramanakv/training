import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'comp1',
  template: `
    <p>
      This is comp1 from extra module
    </p>
  `,
  styles: [
  ]
})
export class Comp1Component implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
