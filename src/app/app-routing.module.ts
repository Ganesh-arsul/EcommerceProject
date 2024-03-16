import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './module/common/home/home.component';
import { SignInComponent } from './module/common/signin/signin.component';

const routes: Routes = [
  {
    path:'',    
    component:HomeComponent
  },
  {
    path:'signin',
    component:SignInComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
