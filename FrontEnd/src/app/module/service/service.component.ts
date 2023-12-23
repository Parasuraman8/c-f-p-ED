import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-service',
  templateUrl: './service.component.html',
  styleUrls: ['./service.component.css']
})
export class ServiceComponent {

  constructor(private router : Router) {}
  

  loginForm() {
    this.router.navigate(['/home/login']);
  }

  

}
