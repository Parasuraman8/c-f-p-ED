import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { auto } from '@popperjs/core';
import { AuthGard } from 'src/app/comman/auth-gard';
import { credential } from 'src/app/comman/credential';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent {

  constructor (private router : Router, private storage : credential  ) {

    
  }


  images = [ 

    'assets/EDBanner1.jpg',
    'assets/EDBanner2.jpg',
    'assets/EDBanner3.jpg',
    'assets/EDBanner4.jpg',
    'assets/EDBanner5.jpg',
    'assets/EDBanner6.jpg',
  ];

  slideInterval = 2500;


  goProfile() {

    if(this.storage.getRole()=='EDU'){
      this.router.navigate(['/home/Edu-page']);
    } else if(this.storage.getRole()=='EDO') {
      this.router.navigate(['/home/Edo-page']);
    } else if(this.storage.getRole()=='EDA') {
      this.router.navigate(['/home/Eda-page']);

    }

  }

  isLogin() {
    return this.storage.getLogin();
  }


  loginForm() {
    this.router.navigate(['/home/login']);
  }

}
