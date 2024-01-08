import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-histroy',
  templateUrl: './user-histroy.component.html',
  styleUrls: ['./user-histroy.component.css']
})
export class UserHistroyComponent {

  constructor(private router : Router) {}

  BackPage() {
    this.router.navigate(['/home/Edu-page/User-Payment']);
  }

}
