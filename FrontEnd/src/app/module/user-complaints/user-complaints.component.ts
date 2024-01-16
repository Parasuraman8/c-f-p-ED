import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UserServiceService } from 'src/app/service/user-service.service';

@Component({
  selector: 'app-user-complaints',
  templateUrl: './user-complaints.component.html',
  styleUrls: ['./user-complaints.component.css']
})
export class UserComplaintsComponent {

  senderDetail?:any;

  constructor( private service: UserServiceService,private router : Router) {
    this.getSender();
  }

  BackPage() {
    this.router.navigate(['/home/Edu-page/User-Payment']);
  }

  getSender() {
    this.service.geSender().subscribe(
      (response)=>{
          this.senderDetail = response;
          this.totalItems = this.senderDetail.length;
          console.log(this.senderDetail);
      }
    );
  }

  
  currentPage = 1;
  itemsPerPage = 5;
  totalItems?: any;

  getDisplayData() : any[] {
    const startIndex = (this.currentPage - 1)* this.itemsPerPage;
    const endIndex = startIndex + this.itemsPerPage;
    return this.senderDetail.slice(startIndex,endIndex);
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
