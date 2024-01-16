import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { credential } from 'src/app/comman/credential';
import { LoginServiceService } from 'src/app/service/login-service.service';
import { UserServiceService } from 'src/app/service/user-service.service';

@Component({
  selector: 'app-user-home',
  templateUrl: './user-home.component.html',
  styleUrls: ['./user-home.component.css']
})
export class UserHomeComponent {

  response : any;


  constructor(
    private loginservice : LoginServiceService,
    private storage : credential,
    private router : Router,
    private service : UserServiceService
  ) {
    this.getUser();
  }

  getUser() {
    this.service.getUser().subscribe(
      (Response)=> {
        this.response = Response;
        console.log(this.response);
      }
    );
  }

  logout() {
    this.router.navigate(['/home']);
    this.loginservice.logout();
    this.storage.removeTokenAndRole();
    this.storage.setLogin(false);
  }


}
