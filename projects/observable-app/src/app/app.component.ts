import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit {
  title = 'observableapp';

  ngOnInit(): void {
    var observable = new Observable((observer: any) => {
      observer.next('I am number 1');
      observer.next('I am number 2');
      observer.error('I am number 3');
      observer.complete();
    });

    observable.subscribe({
      next(message: any)  {
        console.log(message);
      },
      error(err) {
        console.log('Error' + err);
      },

      complete() {
        console.log('Job completed');
      }
    });
  }
}
