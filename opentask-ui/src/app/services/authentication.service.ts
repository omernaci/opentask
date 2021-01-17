import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class AuthenticationService {
  constructor() {}

  authenticate(username, password) {
    if (username != '' && password != '') {
      sessionStorage.setItem('username', username);
      return true;
    }
    return false;
  }

  isUserLoggedIn() {
    if (sessionStorage.getItem('username') !== null) return true;
    return false;
  }

  logout() {
    sessionStorage.removeItem('username');
  }
}
