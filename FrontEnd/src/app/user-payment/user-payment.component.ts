import { Component } from '@angular/core';
import { credential } from '../comman/credential';
import { LoginServiceService } from '../service/login-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-payment',
  templateUrl: './user-payment.component.html',
  styleUrls: ['./user-payment.component.css']
})
export class UserPaymentComponent {

  constructor(
    private loginservice : LoginServiceService,
    private storage : credential,
    private router : Router
  ) {}


  logout() {
    this.router.navigate(['/home']);
    this.loginservice.logout();
    this.storage.removeTokenAndRole();
    this.storage.setLogin(false);
  }

}
