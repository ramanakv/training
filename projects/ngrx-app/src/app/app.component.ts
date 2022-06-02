import { Component, OnInit } from '@angular/core';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { CourseItem } from './store/models/courseItem.model';
import { AppState } from './store/models/app-state.model';
import { NgForm } from '@angular/forms';
import { AddItemAction } from './store/actions/course.action';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit {
  courseItems: Observable<Array<CourseItem>>={} as Observable<Array<CourseItem>>
  constructor(private store: Store<AppState>) {}
  ngOnInit(): void {
    this.courseItems = this.store.select((store) => store.courses);
  }
  addCourse(form: NgForm) {
    this.store.dispatch(new AddItemAction(form.value));
    form.reset();
}
}