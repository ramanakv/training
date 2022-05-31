import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AboutComponent } from './about/about.component';
import { AppComponent } from './app.component';

import { EmpDetailsComponent } from './emp-details/emp-details.component';
import { EmpListComponent } from './emp-list/emp-list.component';
import { HomeComponent } from './home/home.component';
import { NewsComponent } from './news/news.component';
import { NotFoundComponent } from './not-found/not-found.component';


const routes: Routes = [
  {path:'',component:HomeComponent},
  {path:'home',component:HomeComponent},
  {path:'news',component:NewsComponent},
  {path:'emplist',component:EmpListComponent,
  children: [
    {path:"get/:eid",component:EmpDetailsComponent},
  ]

  },
  {path:'about',component:AboutComponent},
  {path:"**",component:NotFoundComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
