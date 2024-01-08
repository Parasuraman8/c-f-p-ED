import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { credential } from 'src/app/comman/credential';
import { LoginServiceService } from 'src/app/service/login-service.service';

@Component({
  selector: 'app-officer-payment',
  templateUrl: './officer-payment.component.html',
  styleUrls: ['./officer-payment.component.css']
})
export class OfficerPaymentComponent {

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
