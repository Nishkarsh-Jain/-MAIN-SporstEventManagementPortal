import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

import { UserDetails } from './../userDetails';
import { AuthenticationResponse } from './../autheniticationResponse';

import { UserManagementService } from './../user-management.service';
import { Router, ActivatedRoute } from '@angular/router';
import { UserCredential } from 'src/app/userCredential';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css'],
})
export class LoginPageComponent implements OnInit {
  token!: string;
  errMsg!: string;
  user: UserCredential = {
    userid: '',
    password: '',
  };
  userDtls!: UserDetails;

  authResponse: AuthenticationResponse = {
    id: '',
    username: '',
    isValid: false,
  };

  isShown: boolean = false;

  permission!: boolean;

  constructor(
    private userManagementService: UserManagementService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {}

  onLogin(userCredential: UserCredential) {
    this.user.userid = userCredential.userid;
    console.log(this.user);
    localStorage.setItem('name', this.user.userid);
    this.userManagementService.loginMember(userCredential).subscribe(
      (data) => {
        this.errMsg = '';
        this.userDtls = data as UserDetails;

        localStorage.setItem('token', this.userDtls.authToken);

        this.router.navigate(['/HomePage']);
      },
      (_error) => {
        this.errMsg = 'Invalid Credentials!';
        console.log(this.errMsg);
      }
    );
  }
}
