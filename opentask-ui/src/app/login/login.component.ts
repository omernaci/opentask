import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  username = ''
  password = ''
  errorMessage = 'Invalid Credentials'
  invalidLogin = false
  returnUrl: string;

  constructor(
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    // get return url from route parameters or default to '/'
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
  }

  handleJWTAuthLogin() {
    console.log("username:"+ this.username + ", password:"+ this.password);
    this.router.navigate(['tasks']);
    // this.basicAuthenticationService.executeJWTAuthenticationService(this.username, this.password)
    //     .subscribe(
    //       data => {
    //         console.log(data)
    //         this.router.navigate(['welcome', this.username])
    //         this.invalidLogin = false
    //       },
    //       error => {
    //         console.log(error)
    //         this.invalidLogin = true
    //       }
    //     )
  }
}
