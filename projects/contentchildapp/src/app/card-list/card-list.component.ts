import { Component } from '@angular/core';

@Component({
  selector: 'card-list',
  template: `
  
  <h1> Card List</h1>

      <card>
        <header #header><h1>Angular</h1></header>
        <content #content>One framework. Mobile & desktop.</content>
        <footer><b>Super-powered by Google </b></footer>
      </card>
        
      
  `,
})
export class CardListComponent {

}