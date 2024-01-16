import { Component, OnDestroy } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { credential } from 'src/app/comman/credential';
import { UserSignUp } from 'src/app/pojo/user-sign-up';
import { DataService } from 'src/app/service/data-service.service';
import { UserServiceService } from 'src/app/service/user-service.service';

@Component({
  selector: 'app-user-info',
  templateUrl: './user-info.component.html',
  styleUrls: ['./user-info.component.css']
})
export class UserInfoComponent implements OnDestroy {

  userInfoId = " ";
  private subcrib : Subscription;

  userInfo : any;
  request : any;

  constructor(private shareData : DataService ,private service : UserServiceService,private storage : credential,private router:Router) {
    this.subcrib = this.shareData.sharedString$.subscribe(
      (newString)=> (this.userInfoId = newString)
      
    );
    this.getUserInfo();
    
  }
  ngOnDestroy(): void {
    this.subcrib.unsubscribe();
  }

  getUserInfo() {
    this.service.getUserByID(this.userInfoId).subscribe(
      (respo)=> {
        this.request = respo;        
      }
    );
  }

  updateUser() {
    this.service.updateUser(this.request).subscribe(
      (updateUser)=> {
        alert("Changes Saved");
        if(this.storage.getRole()=='EDA') {
          this.router.navigate(['/home/Eda-page/Manager/Manage-User']);
        } else {
          this.router.navigate(['/home/Edo-page/officer-manager/Manage-User']);
        }
      }
    );
  }

  Back() {
    if(this.storage.getRole()=='EDA') {
      this.router.navigate(['/home/Eda-page/Manager/Manage-User']);
    } else {
      this.router.navigate(['/home/Edo-page/officer-manager/Manage-User']);
    }
  }
}
