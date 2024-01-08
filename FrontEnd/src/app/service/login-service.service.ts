import { Injectable } from '@angular/core';
import { LoginRequest } from '../pojo/login-request';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { LoginResponse } from '../pojo/login-response';
import { LOGIN_URL } from '../comman/constant';
import { Observable, map } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {

  isAuthenticated = false; //false

  constructor(private http:HttpClient) { }

  login(request:LoginRequest) : Observable<LoginResponse>{

    const requestBody =  {"username":request.username, "password": request.password};

    if(request.password && request.username) {

      this.isAuthenticated = true;

    return this.http.post<LoginResponse>(LOGIN_URL,requestBody);

    } else {
      this.isAuthenticated = false;//false
      alert("please verify your username and password");
      return this.http.post<LoginResponse>(LOGIN_URL,requestBody);
    }
    
  }

  logout() {

    this.isAuthenticated = false;
  }
}
