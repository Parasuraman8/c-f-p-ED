import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { credential } from 'src/app/comman/credential';

@Component({
  selector: 'app-creden-info',
  templateUrl: './creden-info.component.html',
  styleUrls: ['./creden-info.component.css']
})
export class CredenInfoComponent {

  constructor(private storage : credential,private router:Router) {}

  Back() {
    if(this.storage.getRole()=='EDA') {
      this.router.navigate(['/home/Eda-page/Manager/Manage-Creden']);
    } else {
      this.router.navigate(['/home/Edo-page/officer-manager/Manage-Creden']);
    }
  }
}
