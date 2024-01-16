import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { MODIFY_ED_PAYMENT, MODIFY_ED_PAYMENT_ID } from 'src/app/comman/constant';
import { credential } from 'src/app/comman/credential';
import { LoginServiceService } from 'src/app/service/login-service.service';
import { UserServiceService } from 'src/app/service/user-service.service';

@Component({
  selector: 'app-officer-payment',
  templateUrl: './officer-payment.component.html',
  styleUrls: ['./officer-payment.component.css']
})
export class OfficerPaymentComponent {

  constructor(
    private http : HttpClient,
    private loginservice : LoginServiceService,
    private storage : credential,
    private router : Router,
    private service : UserServiceService
  ) {
    this.getPayment();
  }


  senderDetail:any;


  logout() {
    this.router.navigate(['/home']);
    this.loginservice.logout();
    this.storage.removeTokenAndRole();
    this.storage.setLogin(false);
  }

  getPayment() {
    this.service.getAllPayment().subscribe(
      (response)=>{
          this.senderDetail = response;
          this.totalItems = this.senderDetail.length;
          console.log(this.senderDetail);
      }
    );
  }

  illegal(some:string) {
    this.http.put<any>(MODIFY_ED_PAYMENT+"False"+MODIFY_ED_PAYMENT_ID+some,null).subscribe(
      (Response)=> {
        console.log(Response);
        this.senderDetail = this.senderDetail.filter((senderDetail: { paymentId: string; }) => senderDetail.paymentId !== some);
        this.totalItems = this.senderDetail.length;
        alert("complaint registered");
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
