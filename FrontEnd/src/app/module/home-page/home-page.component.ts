import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent {

  constructor (private router : Router) {

  }

  loginForm() {
    this.router.navigate(['/home/login']);
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

}
