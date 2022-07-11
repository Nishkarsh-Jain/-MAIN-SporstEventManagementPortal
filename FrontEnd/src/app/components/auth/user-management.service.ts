import { UserCredential } from 'src/app/userCredential';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/'


@Injectable({
  providedIn: 'root'
})
export class UserManagementService {

  user: UserCredential = {
    "userid": "admin",
    "password": "root"
  }
  private loginUrl: string;



  constructor(private http: HttpClient) {
    this.loginUrl = 'http://localhost:8084/api/auth/login';
   
  }

  generateToken(user: UserCredential): Observable<Object> {
    return this.http.post(this.loginUrl, user, { responseType: 'text' as 'json' })
  }

  validateToken(token: string) {
    let tokenStr = 'Bearer ' + token;
    let validateUrl = 'http://localhost:8084/api/auth/validate'
   
    console.log(tokenStr);
    
    const header = {
      headers: {
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*',
        'Access-Control-Allow-Headers': 'Content-Type',
        'Access-Control-Allow-Methods': 'GET,POST,OPTIONS,DELETE,PUT',
        'Authorization': `Bearer ${token}`
      }
    }
   
    return this.http.get("http://localhost:8084/api/auth/validate", header)
  }

  loginMember(userCredential: UserCredential) {
    return this.http.post(`${this.loginUrl}`, userCredential);
  }

}
