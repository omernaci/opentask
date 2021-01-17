import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateTaskComponent } from './components/create-task/create-task.component';
import { TaskListComponent } from './components/task-list/task-list.component';
import { LoginComponent } from './login/login.component';
import { RouteGuardService } from './services/route-guard.service';

const routes: Routes = [
  {path:'', component:LoginComponent},//default page is login
  {path:'login', component:LoginComponent},
  {path:'tasks', component:TaskListComponent, canActivate:[RouteGuardService]},
  {path:'create-task', component:CreateTaskComponent, canActivate:[RouteGuardService]},
  {path:'**', component:TaskListComponent}//go to task list component when an invalid page requested
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
