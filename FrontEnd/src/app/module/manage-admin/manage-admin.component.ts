import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { DELETE_ED_ADMIN } from 'src/app/comman/constant';
import { credential } from 'src/app/comman/credential';
import { AdminSerService } from 'src/app/service/admin-ser.service';
import { DataService } from 'src/app/service/data-service.service';

@Component({
  selector: 'app-manage-admin',
  templateUrl: './manage-admin.component.html',
  styleUrls: ['./manage-admin.component.css']
})
export class ManageAdminComponent {

  constructor(private dataShare:DataService, private http:HttpClient,private service : AdminSerService,private storage : credential,private router : Router) {
    this.getAllUser();
  }

  BackPage() {
    if(this.storage.getRole()=='EDA') {
      this.router.navigate(['/home/Eda-page/Manager']);
    } else {
      this.router.navigate(['/home/Edo-page/officer-manager'])
    }
    
  }

  view(hell:string) {
    this.dataShare.updateSharedString(hell);
    this.router.navigate(['/home/Eda-page/Manager/Manage-Admin/Admin-info'])

}

remove(hell:string){
  this.http.delete(DELETE_ED_ADMIN + hell, { responseType: 'text' }).subscribe(
    (response) => {
      console.log('Response:', response);
      alert(hell + ' was deleted!!!');
      // Create a new array reference after successful delete
      this.listOfAdmin = this.listOfAdmin.filter((admin: { edaid: string; }) => admin.edaid !== hell);
      this.totalItems = this.listOfAdmin.length;
    },
    (error) => {
      console.error('Error:', error);
      alert('Error while delete ' + hell);
    }
  );
}

showForm() {
  if(this.storage.getRole()=='EDA') {
    this.router.navigate(['/home/Eda-page/Manager/Manage-Admin/New-Admin']);
  } else {
    this.router.navigate(['/home/Edo-page/officer-manager/Manage-Admin/New-Admin'])
  }

}

listOfAdmin:any;
currentPage = 1;
itemsPerPage = 5;
totalItems?: any;

getAllUser() {
  this.service.getAllAdmin().subscribe(
    (Response) => {
      console.log(Response)
      this.listOfAdmin = Response;
      this.totalItems = this.listOfAdmin.length;
    }
  );
}

getDisplayData(): any[] {
  const startIndex = (this.currentPage - 1) * this.itemsPerPage;
  const endIndex = startIndex + this.itemsPerPage;
  return this.listOfAdmin.slice(startIndex, endIndex);
}

nextPage() : void {
  if(this.currentPage< this.totalPages()) {
    this.currentPage++;
  }
}

previousPage():void {
  if( this.currentPage > 1) {
    this.currentPage --;
  }
}

totalPages() :number {
  return Math.ceil(this.totalItems / this.itemsPerPage);
}

}
