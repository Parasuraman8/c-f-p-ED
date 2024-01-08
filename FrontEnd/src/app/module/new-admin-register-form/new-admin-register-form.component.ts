import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { credential } from 'src/app/comman/credential';

@Component({
  selector: 'app-new-admin-register-form',
  templateUrl: './new-admin-register-form.component.html',
  styleUrls: ['./new-admin-register-form.component.css']
})
export class NewAdminRegisterFormComponent {
  
  constructor( private st : credential, private router : Router) { }

  closeRegisterForm() {

    if(this.st.getRole()=='EDA') {
      this.router.navigate(['/home/Eda-page/Manager/Manage-User']);

    } else {
      this.router.navigate(['/home/login']);
    }
 
  }

}
