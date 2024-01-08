import { IfStmt } from '@angular/compiler';
import { Component, Output, EventEmitter } from '@angular/core';
import { Router } from '@angular/router';
import { credential } from 'src/app/comman/credential';
import { LoginRequest } from 'src/app/pojo/login-request';
import { LoginResponse } from 'src/app/pojo/login-response';
import { LoginServiceService } from 'src/app/service/login-service.service';
import { loginservice } from 'src/app/service/loginservice';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent {

  
 loginservice: LoginServiceService;

 loginrequest : LoginRequest = new LoginRequest();

 load : loginservice = new loginservice();
 loginresponse : LoginResponse = new LoginResponse();

  constructor( load : loginservice, private storage : credential,private router : Router, service : LoginServiceService) {

    this.loginservice = service;
  }

  closeLoginForm() {
    this.router.navigate(['/home']);
  
  }

  showRegisterForm() {
    this.router.navigate(['/home/login/new-user-register-form']);
  }

  login() {

    if(this.loginrequest.password==null || this.loginrequest.username==null) {
      alert("please Enter the Username & Password")
    } else {
      this.loginservice?.login(this.loginrequest)
  .subscribe(
    (response:any)=> {

      this.storage.setTokenAndRole(response);
      this.storage.setLogin(true);

      this.load.showLoading();
      
     
      setTimeout(()=>{

          if(this.storage.getRole()=="EDU"){
            this.router.navigate(['/home/Edu-page']);
            this.load.hideLoading();
          } else if(this.storage.getRole()=="EDA"){
            this.router.navigate(['/home/Eda-page']);
          } else if(this.storage.getRole()=="EDO") {
            this.router.navigate(['/home/Edo-page']);
          }

      },5000);
    },
    (error)=> {
      console.error(error);
    }
  );
    }
  
  }



}
