import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthGard } from '../comman/auth-gard';
import { credential } from '../comman/credential';
import { LoginServiceService } from '../service/login-service.service';

@Component({
  selector: 'app-user-bank',
  templateUrl: './user-bank.component.html',
  styleUrls: ['./user-bank.component.css']
})
export class UserBankComponent {

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
