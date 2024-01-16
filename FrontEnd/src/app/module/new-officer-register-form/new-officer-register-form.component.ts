import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { credential } from 'src/app/comman/credential';
import { OfficerSignUp } from 'src/app/pojo/officer-sign-up';
import { OfficerServeService } from 'src/app/service/officer-serve.service';

@Component({
  selector: 'app-new-officer-register-form',
  templateUrl: './new-officer-register-form.component.html',
  styleUrls: ['./new-officer-register-form.component.css']
})
export class NewOfficerRegisterFormComponent {

  constructor(private servie:OfficerServeService, private st : credential, private router : Router) { }

  officerRequest : OfficerSignUp =  new OfficerSignUp;

  closeRegisterForm() {

    if(this.st.getRole()=='EDA') {
      this.router.navigate(['/home/Eda-page/Manager/Manage-Officer']);

    } else if( this.st.getRole()=='EDO') {
      this.router.navigate(['/home/Edo-page/officer-manager/Manage-Officer']);
    }
 
  }

  createOfficer() {
    this.servie.createOfficer(this.officerRequest).subscribe(
      (respo)=> {
        alert("Officer Created! \nUsername : "+respo.edoid+"\nPassword : "+respo.dob);
        console.log(respo);
        
    if(this.st.getRole()=='EDA') {
      this.router.navigate(['/home/Eda-page/Manager/Manage-Officer']);

    } else if( this.st.getRole()=='EDO') {
      this.router.navigate(['/home/Edo-page/officer-manager/Manage-Officer']);
    }
        
      },(error) => {
        console.log(error);
        
      }
    );
    
  }
}
