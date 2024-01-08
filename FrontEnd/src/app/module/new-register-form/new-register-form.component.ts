import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { credential } from 'src/app/comman/credential';

@Component({
  selector: 'app-new-register-form',
  templateUrl: './new-register-form.component.html',
  styleUrls: ['./new-register-form.component.css']
})
export class NewRegisterFormComponent {

  constructor( private st : credential, private router : Router) { }

  closeRegisterForm() {

    if(this.st.getRole()=='EDA') {
      this.router.navigate(['/home/Eda-page/Manager/Manage-User']);

    } else if( this.st.getRole()=='EDO') {
      this.router.navigate(['/home/Edo-page/officer-manager/Manage-User']);
    } else {
      this.router.navigate(['/home/login']);
    }
 
  }

}
