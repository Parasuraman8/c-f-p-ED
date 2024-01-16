import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent } from '@angular/common/http';
import { Observable } from 'rxjs';
import { LoginResponse } from '../pojo/login-response';
import { credential } from './credential';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

    loginresponse : LoginResponse;

    constructor(private local : credential,response:LoginResponse){

        this.loginresponse = response;

    }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const token = this.local.getToken();

    const isLoginUrl = request.url.includes("/login");


    
    const modifiedRequest = token && !isLoginUrl
    ? request.clone({ setHeaders: { Authorization: `${token}` } })
    : request;

    return next.handle(modifiedRequest);
  }
}
