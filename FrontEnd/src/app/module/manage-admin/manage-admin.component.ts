import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { credential } from 'src/app/comman/credential';

@Component({
  selector: 'app-manage-admin',
  templateUrl: './manage-admin.component.html',
  styleUrls: ['./manage-admin.component.css']
})
export class ManageAdminComponent {

  constructor(private storage : credential,private router : Router) {}

  BackPage() {
    if(this.storage.getRole()=='EDA') {
      this.router.navigate(['/home/Eda-page/Manager']);
    } else {
      this.router.navigate(['/home/Edo-page/officer-manager'])
    }
    
  }

  view(hell:string) {

    this.router.navigate(['/home/Eda-page/Manager/Manage-Admin/Admin-info']);

}
showForm() {
  if(this.storage.getRole()=='EDA') {
    this.router.navigate(['/home/Eda-page/Manager/Manage-Admin/New-Admin']);
  } else {
    this.router.navigate(['/home/Edo-page/officer-manager/Manage-Admin/New-Admin'])
  }

}
}
