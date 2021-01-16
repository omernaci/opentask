import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateTaskComponent } from './components/create-task/create-task.component';
import { TaskListComponent } from './components/task-list/task-list.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  {path:'', component:LoginComponent},//default page is login
  {path:'login', component:LoginComponent},
  {path:'**', component:TaskListComponent},//go to task list component when an invalid page requested
  {path:'tasks', component:TaskListComponent},
  {path:'create-task', component:CreateTaskComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
