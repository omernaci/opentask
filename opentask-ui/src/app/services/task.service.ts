import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { AuthenticationService } from './authentication.service';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  constructor(private http: HttpClient, private authService: AuthenticationService) { }

  getTaskList(){
    return this.http.get<any>(`${environment.apiUrl}/api/v1/tasks`);
  }

  updateTask(task){
    return this.http.put<any>(environment.apiUrl,{params : task})
  }

  deleteTask(id){
    return this.http.delete(`${environment.apiUrl}/api/v1/tasks/${id}`);
  }
}
