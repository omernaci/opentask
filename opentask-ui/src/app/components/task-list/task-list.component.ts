import { Component, OnInit } from '@angular/core';
import { TaskService } from 'src/app/services/task.service';
interface Country {
  name: string;
  flag: string;
  area: number;
  population: number;
}

const COUNTRIES: Country[] = [
  {
    name: 'Russia',
    flag: 'f/f3/Flag_of_Russia.svg',
    area: 17075200,
    population: 146989754
  },
  {
    name: 'Canada',
    flag: 'c/cf/Flag_of_Canada.svg',
    area: 9976140,
    population: 36624199
  },
  {
    name: 'United States',
    flag: 'a/a4/Flag_of_the_United_States.svg',
    area: 9629091,
    population: 324459463
  },
  {
    name: 'China',
    flag: 'f/fa/Flag_of_the_People%27s_Republic_of_China.svg',
    area: 9596960,
    population: 1409517397
  }
];
@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.css']
})
export class TaskListComponent implements OnInit {
  countries = COUNTRIES;
  tasks;
  constructor(private taskService: TaskService) { }

  ngOnInit(): void {
    this.getTaskList();
  }

  private getTaskList() {
    this.taskService.getTaskList().subscribe(data => {
      this.tasks = data.tasks;
    });
  }

  updateTask(){

  }

  deleteTask(id){
    console.log(id);
    this.taskService.deleteTask(id).subscribe(res => {
      this.getTaskList();
    });
  }

}
