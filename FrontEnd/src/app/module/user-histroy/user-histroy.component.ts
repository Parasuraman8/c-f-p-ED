import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UserServiceService } from 'src/app/service/user-service.service';

@Component({
  selector: 'app-user-histroy',
  templateUrl: './user-histroy.component.html',
  styleUrls: ['./user-histroy.component.css']
})

export class UserHistroyComponent {

  constructor(private service : UserServiceService ,private router : Router) {
    this.getSender();
  }

  senderDetail : any;

  BackPage() {
    this.router.navigate(['/home/Edu-page/User-Payment']);
  }

  getSender() {
    this.service.getUserHistory().subscribe(
      (response)=>{
          this.senderDetail = response;
          console.log(response);
          
          this.totalItems = this.senderDetail.length;
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
