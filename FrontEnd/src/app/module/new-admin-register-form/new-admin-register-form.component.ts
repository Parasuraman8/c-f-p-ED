import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { credential } from 'src/app/comman/credential';
import { AdminSignUp } from 'src/app/pojo/admin-sign-up';
import { AdminSerService } from 'src/app/service/admin-ser.service';

@Component({
  selector: 'app-new-admin-register-form',
  templateUrl: './new-admin-register-form.component.html',
  styleUrls: ['./new-admin-register-form.component.css']
})
export class NewAdminRegisterFormComponent {
  
  constructor( private sevice : AdminSerService,private st : credential, private router : Router) { }

  request : AdminSignUp = new AdminSignUp;

  closeRegisterForm() {

    if(this.st.getRole()=='EDA') {
      this.router.navigate(['/home/Eda-page/Manager/Manage-Admin']);

    } else {
      this.router.navigate(['/home/login']);
    }
 
  }

  createAdmin() {
    this.sevice.createAdmin(this.request).subscribe(
      (Response)=> {
        alert("Admin Saved\nUserName : "+Response.edaid+"\nPassword : "+Response.dob);
      },
      (error)=> {
        console.log(error);
        
      }
    );
  }


}
