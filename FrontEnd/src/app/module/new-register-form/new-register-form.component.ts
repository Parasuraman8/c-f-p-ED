import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbAlert } from '@ng-bootstrap/ng-bootstrap';
import { credential } from 'src/app/comman/credential';
import { UserSignUp } from 'src/app/pojo/user-sign-up';
import { UserServiceService } from 'src/app/service/user-service.service';

@Component({
  selector: 'app-new-register-form',
  templateUrl: './new-register-form.component.html',
  styleUrls: ['./new-register-form.component.css']
})
export class NewRegisterFormComponent {

  request : UserSignUp = new UserSignUp;

  constructor( private service : UserServiceService, private st : credential, private router : Router) {    
   }




  closeRegisterForm() {

    if(this.st.getRole()=='EDA') {
      this.router.navigate(['/home/Eda-page/Manager/Manage-User']);

    } else if( this.st.getRole()=='EDO') {
      this.router.navigate(['/home/Edo-page/officer-manager/Manage-User']);
    } else {
      this.router.navigate(['/home/login']);
    }
 
  }

  createUser() {

    this.service.createUser(this.request).subscribe(
      (Response)=> {
        alert("User Detail Saved!!!\n UserName :"+Response.eduid +"  \nPassword : "+this.request.dateOfBirth);
        if(this.st.getRole()=='EDA') {
          this.router.navigate(['/home/Eda-page/Manager/Manage-User']);
        } else if( this.st.getRole()=='EDO') {
          this.router.navigate(['/home/Edo-page/officer-manager/Manage-User']);
        } else {
          this.router.navigate(['/home/login']);
        }
        console.log(Response)
      }, (error) => {
        alert("Bad Request verify all the details fill or not")
        
      }
    );

  }
 

}
