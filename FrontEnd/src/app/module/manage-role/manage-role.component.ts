import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { DELETE_ED_ROLE } from 'src/app/comman/constant';
import { credential } from 'src/app/comman/credential';
import { AdminSerService } from 'src/app/service/admin-ser.service';
import { DataService } from 'src/app/service/data-service.service';

@Component({
  selector: 'app-manage-role',
  templateUrl: './manage-role.component.html',
  styleUrls: ['./manage-role.component.css']
})
export class ManageRoleComponent {

  constructor(private shareData:DataService ,private http:HttpClient,private service : AdminSerService,private storage: credential,private router : Router) {
    this.getAllRoles();
  }

  BackPage() {
    if(this.storage.getRole()=='EDA') {
      this.router.navigate(['/home/Eda-page/Manager']);
    } else {
      this.router.navigate(['/home/Edo-page/officer-manager'])
    }
    
  }

  view(hell:string) {
    this.shareData.updateSharedString(hell);
    this.router.navigate(['/home/Eda-page/Manager/Manage-Role/Role-info']);
   
  }

  showForm() {
    this.router.navigate(['/home/Eda-page/Manager/Manage-Role/New-Role']);
  }

  listOfRoles:any;
  noOfRole:any;

  getAllRoles() {


    this.service.getAllRoles().subscribe(
      (Response) => {
        this.listOfRoles = Response;
        this.noOfRole = this.listOfRoles.length;        
      }
    );
  }

  remove(hell: string) {
    this.http.delete(DELETE_ED_ROLE + hell, { responseType: 'text' }).subscribe(
      (response) => {
        alert(hell + ' was deleted!!!');
        this.listOfRoles = this.listOfRoles.filter((roles: { role: string; }) => roles.role !== hell);
        this.noOfRole = this.listOfRoles.length;
      },
      (error) => {
        console.error('Error:', error);
        alert("you need to delete user & officer before the role delete ");
      }
    );
  }
}
