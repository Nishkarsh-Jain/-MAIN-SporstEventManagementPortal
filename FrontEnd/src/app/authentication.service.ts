import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  url:string="http://localhost:8084/api/auth/login"
  constructor(private http:HttpClient) {

  }
}
