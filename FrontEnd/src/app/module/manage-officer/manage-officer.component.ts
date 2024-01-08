import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { credential } from 'src/app/comman/credential';

@Component({
  selector: 'app-manage-officer',
  templateUrl: './manage-officer.component.html',
  styleUrls: ['./manage-officer.component.css']
})
export class ManageOfficerComponent {

  constructor(private storage: credential,private router : Router) {}

  BackPage() {
    if(this.storage.getRole()=='EDA') {
      this.router.navigate(['/home/Eda-page/Manager']);
    } else {
      this.router.navigate(['/home/Edo-page/officer-manager'])
    }
    
  }
  view(hell:string) {

    if(this.storage.getRole()=='EDA') {
      this.router.navigate(['/home/Eda-page/Manager/Manage-Officer/Officer-info']);
    } else {
      this.router.navigate(['/home/Edo-page/officer-manager/Manage-Officer/Officer-info'])
    }
  }

  showForm() {
    if(this.storage.getRole()=='EDA') {
      this.router.navigate(['/home/Eda-page/Manager/Manage-Officer/New-Officer']);
    } else {
      this.router.navigate(['/home/Edo-page/officer-manager/Manage-Officer/New-Officer']);
    }

  }
}
