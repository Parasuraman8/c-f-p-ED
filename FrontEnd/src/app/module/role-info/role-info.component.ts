import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { credential } from 'src/app/comman/credential';
import { AdminSerService } from 'src/app/service/admin-ser.service';
import { DataService } from 'src/app/service/data-service.service';

@Component({
  selector: 'app-role-info',
  templateUrl: './role-info.component.html',
  styleUrls: ['./role-info.component.css']
})
export class RoleInfoComponent {
  subcrib : Subscription;


  constructor(private shareData:DataService,private service : AdminSerService,private storage : credential,private router:Router) {
    this.subcrib = this.shareData.sharedString$.subscribe(
      (newString)=> (this.roleId = newString)
      
    );
    this.getRole();
  }

  roleId:any
  request : any;

  Back() {
    if(this.storage.getRole()=='EDA') {
      this.router.navigate(['/home/Eda-page/Manager/Manage-Role']);
    } else {
      this.router.navigate(['/home/Edo-page/officer-manager/Manage-Role']);
    }
  }

  getRole() {
    this.service.getRoleById(this.roleId).subscribe(
      (Response)=> {
        console.log(Response);
        
        this.request = Response;
      },(error)=> {
        console.log(error);
        
      }
    );
  }

  updateRole() {
    this.service.updateRole(this.roleId,this.request).subscribe(
      (updateUser)=> {
        alert("Changes Saved");
        if(this.storage.getRole()=='EDA') {
          this.router.navigate(['/home/Eda-page/Manager/Manage-Role']);
        } else {
          this.router.navigate(['/home/Edo-page/officer-manager/Manage-Role']);
        }
      },(error)=> {
        console.log(error);
        
      }
    );
  }
}
