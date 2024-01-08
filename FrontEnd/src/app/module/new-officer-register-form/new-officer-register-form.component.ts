import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { credential } from 'src/app/comman/credential';

@Component({
  selector: 'app-new-officer-register-form',
  templateUrl: './new-officer-register-form.component.html',
  styleUrls: ['./new-officer-register-form.component.css']
})
export class NewOfficerRegisterFormComponent {

  constructor( private st : credential, private router : Router) { }

  closeRegisterForm() {

    if(this.st.getRole()=='EDA') {
      this.router.navigate(['/home/Eda-page/Manager/Manage-Officer']);

    } else if( this.st.getRole()=='EDO') {
      this.router.navigate(['/home/Edo-page/officer-manager/Manage-Officer']);
    } else {
      this.router.navigate(['/home/login']);
    }
 
  }
}
