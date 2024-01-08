import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { credential } from 'src/app/comman/credential';

@Component({
  selector: 'app-manage-credential',
  templateUrl: './manage-credential.component.html',
  styleUrls: ['./manage-credential.component.css']
})
export class ManageCredentialComponent {

  
  constructor(private storage: credential,private router : Router) {}

  BackPage() {
    if(this.storage.getRole()=='EDA') {
      this.router.navigate(['/home/Eda-page/Manager']);
    } else {
      this.router.navigate(['/home/Edo-page/officer-manager'])
    }
    
  }

  view() {
    this.router.navigate(['/home/Eda-page/Manager/Manage-Creden/Creden-info']);
  }

}
