import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-complaints',
  templateUrl: './user-complaints.component.html',
  styleUrls: ['./user-complaints.component.css']
})
export class UserComplaintsComponent {

  constructor(private router : Router) {}

  BackPage() {
    this.router.navigate(['/home/Edu-page/User-Payment']);
  }

}
