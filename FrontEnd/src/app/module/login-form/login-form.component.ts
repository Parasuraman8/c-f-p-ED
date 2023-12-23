import { Component, Output, EventEmitter } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent {
 

  constructor(private router : Router) {}

  closeLoginForm() {
    this.router.navigate(['/home']);
  
  }

  showRegisterForm() {
    this.router.navigate(['/home/login/new-user-register-form']);
  }

  login() {
    this.router.navigate(['/home/user-profile']);
  }

}
