import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { credential } from 'src/app/comman/credential';
import { LoginServiceService } from 'src/app/service/login-service.service';
import { OfficerServeService } from 'src/app/service/officer-serve.service';
import { UserServiceService } from 'src/app/service/user-service.service';

@Component({
  selector: 'app-edo-home',
  templateUrl: './edo-home.component.html',
  styleUrls: ['./edo-home.component.css']
})
export class EdoHomeComponent {

  constructor(
    private loginservice : LoginServiceService,
    private storage : credential,
    private router : Router,
    private sevice : OfficerServeService
  ) {
    this.getOfficer();
  }

    response : any;


  logout() {
    this.router.navigate(['/home']);
    this.loginservice.logout();
    this.storage.removeTokenAndRole();
    this.storage.setLogin(false);
  } 

  getOfficer() {
    this.sevice.getOfficerById().subscribe(
      (Response)=> {
        this.response = Response;
        console.log(this.response);
      }
    );
  }
  

}
