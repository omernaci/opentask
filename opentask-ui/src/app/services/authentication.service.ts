import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class AuthenticationService {
  AUTH_USER = 'authUser';
  TOKEN = 'token';
  constructor(private http: HttpClient) {}

  jwtAuthentication(username, password){
    return this.http.post<any>(`${environment.apiUrl}/authenticate`,{
      username,
      password
    }).pipe(
      map(
        data =>{
          sessionStorage.setItem(this.AUTH_USER,username);
          sessionStorage.setItem(this.TOKEN,`Bearer ${data.token}`)
          return data;
        }
      )
    );
  }

  isUserLoggedIn() {
    if (sessionStorage.getItem(this.AUTH_USER) !== null) return true;
    return false;
  }

  logout() {
    sessionStorage.removeItem(this.AUTH_USER);
  }

  getAuthenticatedUser() {
    return sessionStorage.getItem(this.AUTH_USER)
  }

  getAuthenticatedToken() {
    if(this.getAuthenticatedUser())
      return sessionStorage.getItem(this.TOKEN)
  }
}
