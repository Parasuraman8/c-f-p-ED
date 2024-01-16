import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { credential } from 'src/app/comman/credential';
import { OfficerServeService } from 'src/app/service/officer-serve.service';

@Component({
  selector: 'app-manage-payment',
  templateUrl: './manage-payment.component.html',
  styleUrls: ['./manage-payment.component.css']
})
export class ManagePaymentComponent {
  
  constructor(private service : OfficerServeService, private storage: credential,private router : Router) {
    this.getAllBank();
  }
  BackPage() {
    if(this.storage.getRole()=='EDA') {
      this.router.navigate(['/home/Eda-page/Manager']);
    } else {
      this.router.navigate(['/home/Edo-page/officer-manager'])
    }
    
  }

  view() {
    if(this.storage.getRole()=='EDA') {
      this.router.navigate(['/home/Eda-page/Manager/Manage-Payment/Payment-info']);
    } else {
      this.router.navigate(['/home/Edo-page/officer-manager/Manage-Payment/Payment-info']);
    }
  }
  listOfBank:any;
  currentPage = 1;
  itemsPerPage = 5;
  totalItems?: any;

  getAllBank() {
    this.service.getAllBank().subscribe(
      (Response) => {
        this.listOfBank = Response;
        this.totalItems = this.listOfBank.length;
        console.log(this.listOfBank);
      }
    );
  }

  getDisplayData() : any[] {
    const startIndex = (this.currentPage - 1)* this.itemsPerPage;
    const endIndex = startIndex + this.itemsPerPage;
    return this.listOfBank.slice(startIndex,endIndex);
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
