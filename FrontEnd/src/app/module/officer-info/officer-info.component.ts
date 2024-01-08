import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { credential } from 'src/app/comman/credential';

@Component({
  selector: 'app-officer-info',
  templateUrl: './officer-info.component.html',
  styleUrls: ['./officer-info.component.css']
})
export class OfficerInfoComponent {
  constructor(private storage : credential,private router:Router) {}

  Back() {
    if(this.storage.getRole()=='EDA') {
      this.router.navigate(['/home/Eda-page/Manager/Manage-Officer']);
    } else {
      this.router.navigate(['/home/Edo-page/officer-manager/Manage-Officer']);
    }
  }

}
