import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { credential } from 'src/app/comman/credential';

@Component({
  selector: 'app-admin-info',
  templateUrl: './admin-info.component.html',
  styleUrls: ['./admin-info.component.css']
})
export class AdminInfoComponent {

  constructor(private storage : credential,private router:Router) {}

  Back() {
    if(this.storage.getRole()=='EDA') {
      this.router.navigate(['/home/Eda-page/Manager/Manage-Admin']);
    } else {
      this.router.navigate(['/home/Edo-page/officer-manager/Manage-Admin']);
    }
  }

}
