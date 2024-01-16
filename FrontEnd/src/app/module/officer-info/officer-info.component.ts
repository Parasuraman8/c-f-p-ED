import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { DELETE_ED_OFFICER } from 'src/app/comman/constant';
import { credential } from 'src/app/comman/credential';
import { DataService } from 'src/app/service/data-service.service';
import { OfficerServeService } from 'src/app/service/officer-serve.service';

@Component({
  selector: 'app-officer-info',
  templateUrl: './officer-info.component.html',
  styleUrls: ['./officer-info.component.css']
})
export class OfficerInfoComponent {

  private subcrib : Subscription;

  officerInfo : any
  request:any;
  
  constructor(private http:HttpClient,private service: OfficerServeService, private shareData : DataService,private storage : credential,private router:Router) {
    this.subcrib = this.shareData.sharedString$.subscribe(
      (newString)=> (this.officerInfo = newString)
    );
    this.getUserInfo();
    
  }
  getUserInfo() {
    this.service.getOfficerByEduId(this.officerInfo).subscribe(
      (respo)=> {
        this.request = respo;
        
      }
    );
  }


  updateUser() {
    this.service.updateOfficer(this.request).subscribe(
      (updateOfficer)=> {
        alert("Changes Saved");
        console.log(updateOfficer);
        
        if(this.storage.getRole()=='EDA') {
          this.router.navigate(['/home/Eda-page/Manager/Manage-Officer']);
        } else {
          this.router.navigate(['/home/Edo-page/officer-manager/Manage-Officer']);
        }
      }
    );
  }

  Back() {
    if(this.storage.getRole()=='EDA') {
      this.router.navigate(['/home/Eda-page/Manager/Manage-Officer']);
    } else {
      this.router.navigate(['/home/Edo-page/officer-manager/Manage-Officer']);
    }
  }

}
