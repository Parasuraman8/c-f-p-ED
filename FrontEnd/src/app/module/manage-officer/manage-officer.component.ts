import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { DELETE_ED_OFFICER } from 'src/app/comman/constant';
import { credential } from 'src/app/comman/credential';
import { DataService } from 'src/app/service/data-service.service';
import { OfficerServeService } from 'src/app/service/officer-serve.service';

@Component({
  selector: 'app-manage-officer',
  templateUrl: './manage-officer.component.html',
  styleUrls: ['./manage-officer.component.css']
})
export class ManageOfficerComponent {

  constructor(private http : HttpClient,private shareData:DataService ,private service : OfficerServeService,private storage: credential,private router : Router) {
    this.getAllOfficer();
  }

  BackPage() {
    if(this.storage.getRole()=='EDA') {
      this.router.navigate(['/home/Eda-page/Manager']);
    } else {
      this.router.navigate(['/home/Edo-page/officer-manager'])
    }
    
  }

  removeOfficer(hell: string) {
    this.http.delete(DELETE_ED_OFFICER + hell, { responseType: 'text' }).subscribe(
      (response) => {
        console.log('Response:', response);
        alert(hell + ' was deleted!!!');
        // Create a new array reference after successful delete
        this.listOfOfficer = this.listOfOfficer.filter((officer: { edoid: string; }) => officer.edoid !== hell);
        this.totalItems = this.listOfOfficer.length;
      },
      (error) => {
        console.error('Error:', error);
        alert('Error while delete ' + hell);
      }
    );
  }
  view(hell:string) {
    this.shareData.updateSharedString(hell);
    console.log(hell);    
    if(this.storage.getRole()=='EDA') {
      this.router.navigate(['/home/Eda-page/Manager/Manage-Officer/Officer-info']);
    } else {
      this.router.navigate(['/home/Edo-page/officer-manager/Manage-Officer/Officer-info'])
    }
  }

  showForm() {
    if(this.storage.getRole()=='EDA') {
      this.router.navigate(['/home/Eda-page/Manager/Manage-Officer/New-Officer']);
    } else {
      this.router.navigate(['/home/Edo-page/officer-manager/Manage-Officer/New-Officer']);
    }

  }

  listOfOfficer:any;
  currentPage = 1;
  itemsPerPage = 5;
  totalItems?: any;

  getAllOfficer() {
    this.service.getAllOfficer().subscribe(
      (Response) => {
        this.listOfOfficer = Response;
        this.totalItems = this.listOfOfficer.length;
      }
    );
  }

  getDisplayData() : any[] {
    const startIndex = (this.currentPage - 1) * this.itemsPerPage;
    const endIndex = startIndex + this.itemsPerPage;
    return this.listOfOfficer.slice(startIndex,endIndex);
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
