import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { MODIFY_ED_PAYMENT, MODIFY_ED_PAYMENT_ID } from 'src/app/comman/constant';
import { credential } from 'src/app/comman/credential';
import { LoginServiceService } from 'src/app/service/login-service.service';
import { UserServiceService } from 'src/app/service/user-service.service';

@Component({
  selector: 'app-complaints',
  templateUrl: './complaints.component.html',
  styleUrls: ['./complaints.component.css']
})
export class ComplaintsComponent {

  constructor(
    private http:HttpClient,
    private loginservice : LoginServiceService,
    private storage : credential,
    private router : Router,
    private service : UserServiceService
  ) {
    this.getAllComplaints();
  }

  senderDetail: any;
  logout() {
    this.router.navigate(['/home']);
    this.loginservice.logout();
    this.storage.removeTokenAndRole();
    this.storage.setLogin(false);
  }

  getAllComplaints() {
    this.service.getAllComplaints().subscribe(
      (Response) => {

        this.senderDetail = Response;
        this.totalItems = this.senderDetail.length;

      }
    );

  }

  removeFromComplaint(hell:any) {
    this.http.put<any>(MODIFY_ED_PAYMENT+"True"+MODIFY_ED_PAYMENT_ID+hell,null).subscribe(
      (Response)=> {
        alert("Complaint revoked!!!");
        this.senderDetail = this.senderDetail.filter((senderDetail: { paymentId: string; }) => senderDetail.paymentId !== hell);
        this.totalItems = this.senderDetail.length;  }
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
