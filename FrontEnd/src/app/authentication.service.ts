import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserCredential } from './userCredential';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  url:string="http://localhost:8084/api/auth/login"
  constructor(private http:HttpClient) {

  }

  loginMember(userCredential: UserCredential) {
    return this.http.post(`${this.url}`, userCredential);
  }
}
