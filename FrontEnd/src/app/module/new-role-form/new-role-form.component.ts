import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { credential } from 'src/app/comman/credential';
import { Roles } from 'src/app/pojo/roles';
import { AdminSerService } from 'src/app/service/admin-ser.service';

@Component({
  selector: 'app-new-role-form',
  templateUrl: './new-role-form.component.html',
  styleUrls: ['./new-role-form.component.css']
})
export class NewRoleFormComponent {

  constructor( private service:AdminSerService,private storage : credential,private router:Router) {}

  roleRequest : Roles = new Roles;

  Back() {
    if(this.storage.getRole()=='EDA') {
      this.router.navigate(['/home/Eda-page/Manager/Manage-Role']);
    } else {
      this.router.navigate(['/home/Edo-page/officer-manager/Manage-Role']);
    }
  }

  createRole() {
    this.service.createRole(this.roleRequest).subscribe(
      (Response)=> {
        alert(Response.role+" was created");
      } , (error)=> {
        alert("error while create Role");
      }
    );
  }

}
