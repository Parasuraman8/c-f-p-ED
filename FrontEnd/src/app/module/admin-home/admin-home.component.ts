import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { credential } from 'src/app/comman/credential';
import { AdminSerService } from 'src/app/service/admin-ser.service';
import { LoginServiceService } from 'src/app/service/login-service.service';

@Component({
  selector: 'app-admin-home',
  templateUrl: './admin-home.component.html',
  styleUrls: ['./admin-home.component.css']
})
export class AdminHomeComponent {


  constructor(
    private service : AdminSerService,
    private loginservice : LoginServiceService,
    private storage : credential,
    private router : Router
  ) {
    this.getAdmin();
  }

username = this.storage.getUsername();

  logout() {
    this.router.navigate(['/home']);
    this.loginservice.logout();
    this.storage.removeTokenAndRole();
    this.storage.setLogin(false);
  }

  response : any;

  getAdmin() {
    this.service.getAdmin().subscribe(
      (Response)=>{
        this.response = Response;
      }, (error)=> {
        console.log(error);
        
      }
    );
  }

}
