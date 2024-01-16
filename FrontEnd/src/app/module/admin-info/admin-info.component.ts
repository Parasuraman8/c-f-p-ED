import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { credential } from 'src/app/comman/credential';
import { AdminSerService } from 'src/app/service/admin-ser.service';
import { DataService } from 'src/app/service/data-service.service';

@Component({
  selector: 'app-admin-info',
  templateUrl: './admin-info.component.html',
  styleUrls: ['./admin-info.component.css']
})
export class AdminInfoComponent {

  subcrib:Subscription;
  adminInfoId : any;
  request : any;

  constructor(private service : AdminSerService,private shareData:DataService,private storage : credential,private router:Router) {
    this.subcrib = this.shareData.sharedString$.subscribe(
      (newString)=> (this.adminInfoId = newString)
     );
     this.getUserInfo();
  }

  
  getUserInfo() {
    this.service.getAdminById(this.adminInfoId).subscribe(
      (respo)=> {
        this.request = respo;        
      }
    );
  }

  updateAdmin() {

  }

  Back() {
    if(this.storage.getRole()=='EDA') {
      this.router.navigate(['/home/Eda-page/Manager/Manage-Admin']);
    } else {
      this.router.navigate(['/home/Edo-page/officer-manager/Manage-Admin']);
    }
  }

}
