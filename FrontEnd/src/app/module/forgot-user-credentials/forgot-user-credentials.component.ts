import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { MODIFY_USER_CREDENTIAL } from 'src/app/comman/constant';

@Component({
  selector: 'app-forgot-user-credentials',
  templateUrl: './forgot-user-credentials.component.html',
  styleUrls: ['./forgot-user-credentials.component.css']
})
export class ForgotUserCredentialsComponent {

  constructor (private http : HttpClient,private router : Router) {}

  backToSignIN() {
    this.router.navigate(['/home/login']);
  }
}
