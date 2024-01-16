import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { credential } from 'src/app/comman/credential';
import { DataService } from 'src/app/service/data-service.service';
import { OfficerServeService } from 'src/app/service/officer-serve.service';

@Component({
  selector: 'app-manage-credential',
  templateUrl: './manage-credential.component.html',
  styleUrls: ['./manage-credential.component.css']
})
export class ManageCredentialComponent {

  
  constructor(private shareData : DataService,private service : OfficerServeService ,private storage: credential,private router : Router) {
    this.getAllCredential();
  }

  BackPage() {
    if(this.storage.getRole()=='EDA') {
      this.router.navigate(['/home/Eda-page/Manager']);
    } else {
      this.router.navigate(['/home/Edo-page/officer-manager'])
    }
    
  }

  view(id:string) {
    this.shareData.updateSharedString(id);
    this.router.navigate(['/home/Eda-page/Manager/Manage-Creden/Creden-info']);
  }

  listOfCredential:any;
  currentPage = 1;
  itemsPerPage = 5;
  totalItems?: any;

  getAllCredential() {
    this.service.getAllCredential().subscribe(
      (Response) => {
        this.listOfCredential = Response;
        this.totalItems = this.listOfCredential.length;
        console.log(Response)
      }
    );
  }

  getDisplayData() : any[] {
    const startIndex = (this.currentPage - 1) * this.itemsPerPage;
    const endIndex = startIndex + this.itemsPerPage;
    return this.listOfCredential.slice(startIndex,endIndex);
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
