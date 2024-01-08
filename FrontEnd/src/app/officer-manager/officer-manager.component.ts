import { Component } from '@angular/core';
import { LoginServiceService } from '../service/login-service.service';
import { credential } from '../comman/credential';
import { Router } from '@angular/router';

@Component({
  selector: 'app-officer-manager',
  templateUrl: './officer-manager.component.html',
  styleUrls: ['./officer-manager.component.css']
})
export class OfficerManagerComponent {

    
  constructor(
    private loginservice : LoginServiceService,
    private storage : credential,
    private router : Router
  ) {}

  logout() {
    this.router.navigate(['/home']);
    this.loginservice.logout();
    this.storage.removeTokenAndRole();
    this.storage.setLogin(false)
  }

}
