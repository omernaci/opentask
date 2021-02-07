import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthenticationService } from '../services/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  username = '';
  password = '';
  errorMessage = 'Invalid Credentials';
  invalidLogin = false;
  returnUrl: string;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private authenticationService: AuthenticationService
  ) {}

  ngOnInit(): void {
    // get return url from route parameters or default to '/'
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
  }

  handleJWTAuthLogin() {
    this.authenticationService.jwtAuthentication(this.username, this.password)
        .subscribe(
          data => {
            console.log(data)
            this.router.navigate(['tasks', this.username])
            this.invalidLogin = false
          },
          error => {
            console.log(error)
            this.invalidLogin = true
          }
        )
  }
}
