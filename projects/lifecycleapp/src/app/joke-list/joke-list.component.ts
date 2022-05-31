import { Component } from "@angular/core";
import { Joke } from "src/joke";

@Component({
  selector: 'joke-list',
  template: `
<joke *ngFor="let j of jokes" [joke]="j">
  <span class="setup">{{ j.setup }} ?</span>
  <h1 class="punchline">{{ j.punchline }}</h1>
</joke>

<button type="button"
        class="btn btn-success"
        (click)="addJoke()">Add Joke
</button>
<button type="button"
        class="btn btn-danger"
        (click)="deleteJoke()">Clear Jokes
</button>
`
})
export class JokeListComponent {
  jokes: Joke[]=[]

  addJoke() {
    this.jokes.unshift(new Joke("What did the cheese say when it looked in the mirror", "Hello-me (Halloumi)"));
  }

  deleteJoke() {
    this.jokes = []
  }
}