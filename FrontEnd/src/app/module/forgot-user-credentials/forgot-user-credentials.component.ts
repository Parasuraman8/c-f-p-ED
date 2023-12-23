import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-forgot-user-credentials',
  templateUrl: './forgot-user-credentials.component.html',
  styleUrls: ['./forgot-user-credentials.component.css']
})
export class ForgotUserCredentialsComponent {

  constructor (private router : Router) {}

  backToSignIN() {
    this.router.navigate(['/home/login']);
  }

  selectedOption : string = 'username';
 

}
