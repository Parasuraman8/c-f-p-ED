import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthGard } from '../comman/auth-gard';
import { credential } from '../comman/credential';
import { LoginServiceService } from '../service/login-service.service';
import { UserServiceService } from '../service/user-service.service';

@Component({
  selector: 'app-user-bank',
  templateUrl: './user-bank.component.html',
  styleUrls: ['./user-bank.component.css']
})
export class UserBankComponent {

  bankResponse : any;

  constructor(
    private loginservice : LoginServiceService,
    private storage : credential,
    private router : Router,
    private sevice : UserServiceService
  ) {
    this.getBank()
  }


  logout() {
    this.router.navigate(['/home']);
    this.loginservice.logout();
    this.storage.removeTokenAndRole();
    this.storage.setLogin(false);
  }

  getBank() {
    this.sevice.getUser().subscribe(
      (response)=> {
        this.bankResponse = response;
        console.log(this.bankResponse);
      }
    );
  }

}
