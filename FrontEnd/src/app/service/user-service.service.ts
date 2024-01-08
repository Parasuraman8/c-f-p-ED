import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { GET_USER_BY_ID } from '../comman/constant';
import { credential } from '../comman/credential';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  constructor(private storage:credential, private http:HttpClient) { }

  getUser() {
    return this.http.get<any>(GET_USER_BY_ID+this.storage.getUsername()).subscribe(
      (Response)=> {
        console.log(Response);
      }
    )
  }
}
