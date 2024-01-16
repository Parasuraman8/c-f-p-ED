import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { share } from 'rxjs';
import { DELETE_ED_USER } from 'src/app/comman/constant';
import { credential } from 'src/app/comman/credential';
import { DataService } from 'src/app/service/data-service.service';
import { UserServiceService } from 'src/app/service/user-service.service';

@Component({
  selector: 'app-manage-user',
  templateUrl: './manage-user.component.html',
  styleUrls: ['./manage-user.component.css']
})
export class ManageUserComponent implements OnInit {

  ngOnInit() {
    this.getAllUser();
  }
  constructor(private http : HttpClient ,private shareData : DataService ,private service : UserServiceService, private storage: credential,private router : Router) {
    this.getAllUser();
  }

  BackPage() {
    if(this.storage.getRole()=='EDA') {
      this.router.navigate(['/home/Eda-page/Manager']);
    } else {
      this.router.navigate(['/home/Edo-page/officer-manager'])
    }
    
  }

  showForm() {
    if(this.storage.getRole()=='EDA') {
      this.router.navigate(['/home/Eda-page/Manager/Manage-User/New-User']);
    } else {
      this.router.navigate(['/home/Edo-page/officer-manager/Manage-User/New-User'])
    }

  }

  userId : string = ' '; 

  view(id:string){
    this.shareData.updateSharedString(id);
    this.router.navigate(['/home/Edo-page/officer-manager/Manage-User/User-info'])
  }
  
  remove(hell: string) {
    this.http.delete(DELETE_ED_USER + hell, { responseType: 'text' }).subscribe(
      (response) => {
        console.log('Response:', response);
        alert(hell + ' was deleted!!!');
        // Create a new array reference after successful delete
        this.listOfUser = this.listOfUser.filter((user: { eduid: string; }) => user.eduid !== hell);
        this.totalItems = this.listOfUser.length;
      },
      (error) => {
        console.error('Error:', error);
        alert('Error while delete ' + hell);
      }
    );
  }
  
  listOfUser:any;
  currentPage = 1;
  itemsPerPage = 5;
  totalItems?: any;

  getAllUser() {
    this.service.getAllUser().subscribe(
      (Response) => {
        this.listOfUser = Response;
        this.totalItems = this.listOfUser.length;
      }
    );
  }

  getDisplayData(): any[] {
    const startIndex = (this.currentPage - 1) * this.itemsPerPage;
    const endIndex = startIndex + this.itemsPerPage;
    return this.listOfUser.slice(startIndex, endIndex);
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
