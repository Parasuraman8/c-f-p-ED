import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { credential } from 'src/app/comman/credential';

@Component({
  selector: 'app-service',
  templateUrl: './service.component.html',
  styleUrls: ['./service.component.css']
})
export class ServiceComponent {

  constructor (private router : Router, private storage : credential  ) {

    
  }

  loginForm() {
    this.router.navigate(['/home/login']);
  }

  goProfile() {

    if(this.storage.getRole()=='EDU'){

      this.router.navigate(['/home/Edu-page']);
    } else if(this.storage.getRole()=='EDO') {
      this.router.navigate(['/home/Edo-page']);
    } else if(this.storage.getRole()=='EDA') {
      this.router.navigate(['/home/Eda-page']);

    }
    console.log(this.storage.getLogin())

  }

  isLogin() {
    return this.storage.getLogin();
  }

  

}
