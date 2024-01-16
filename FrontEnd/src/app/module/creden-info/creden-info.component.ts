import { Component, ɵsetAlternateWeakRefImpl } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { credential } from 'src/app/comman/credential';
import { AdminSerService } from 'src/app/service/admin-ser.service';
import { DataService } from 'src/app/service/data-service.service';

@Component({
  selector: 'app-creden-info',
  templateUrl: './creden-info.component.html',
  styleUrls: ['./creden-info.component.css']
})
export class CredenInfoComponent {

  subcrib:Subscription;
  credenInfoId:any;
  credentResponse: any = {
    username: '',
    password: '',
    edRolesModels: [{
      role: '',
      roleDesc: ''
    }]
  };;


  constructor(private service : AdminSerService,private shareData:DataService ,private storage : credential,private router:Router) {
    this.subcrib = this.shareData.sharedString$.subscribe(
      (newString)=> (this.credenInfoId = newString)
      
    );
    this.getCredentInfo();
  }

  Back() {
    if(this.storage.getRole()=='EDA') {
      this.router.navigate(['/home/Eda-page/Manager/Manage-Creden']);
    } else {
      this.router.navigate(['/home/Edo-page/officer-manager/Manage-Creden']);
    }
  }

  getCredentInfo() {
    this.service.getCredential(this.credenInfoId).subscribe(
      (credentInfo)=> {
        console.log(credentInfo);
        this.credentResponse = credentInfo;
      }
    );
  }

  updateCredent() {
    this.service.updateCredent(this.credenInfoId,this.credentResponse).subscribe(
      (Response)=> {
        console.log(Response);
        
        alert("changes saved")
        if(this.storage.getRole()=='EDA') {
          this.router.navigate(['/home/Eda-page/Manager/Manage-Creden']);
        } else {
          this.router.navigate(['/home/Edo-page/officer-manager/Manage-Creden']);
        }
      }
    );    
  }


}
