import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { credential } from 'src/app/comman/credential';

@Component({
  selector: 'app-new-role-form',
  templateUrl: './new-role-form.component.html',
  styleUrls: ['./new-role-form.component.css']
})
export class NewRoleFormComponent {

  constructor(private storage : credential,private router:Router) {}


  Back() {
    if(this.storage.getRole()=='EDA') {
      this.router.navigate(['/home/Eda-page/Manager/Manage-Role']);
    } else {
      this.router.navigate(['/home/Edo-page/officer-manager/Manage-Role']);
    }
  }

}
