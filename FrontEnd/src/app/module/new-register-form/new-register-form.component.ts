import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-new-register-form',
  templateUrl: './new-register-form.component.html',
  styleUrls: ['./new-register-form.component.css']
})
export class NewRegisterFormComponent {

  constructor( private router : Router) { }

  closeRegisterForm() {
    this.router.navigate(['/home/login']);
  }

}
