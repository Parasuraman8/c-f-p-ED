import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { credential } from 'src/app/comman/credential';
import { PayRequest } from 'src/app/pojo/pay-request';
import { UserServiceService } from 'src/app/service/user-service.service';

@Component({
  selector: 'app-user-payment-send',
  templateUrl: './user-payment-send.component.html',
  styleUrls: ['./user-payment-send.component.css']
})
export class UserPaymentSendComponent {

  pay : PayRequest
  requestBody?:any;
  senderResponse : any = {};
  recevierResponse : any = {};

  constructor(private storage : credential,private service : UserServiceService ,private servi : PayRequest, private router : Router) {
    this.pay = servi;
    this.defauleId = storage.getUsername();
    this.getDetials();
  
  }

  defauleId : any;
  sender : any;

  BackPage() {
    this.router.navigate(['/home/Edu-page/User-Payment']);
  }

  payAmount() {
    this.pay.eduidSender = this.defauleId;
    console.log(this.pay)
    this.pay.isLegal="True"
    this.service.payAmount(this.pay).subscribe(
      (Response) => {
        alert("pay successfully!!!");

        this.router.navigate(['/home/Edu-page/User-Payment']);
      }, (error)=> {
        alert("error while pay");
      }
    );
  }

  getDetials()  {
    this.service.getSenderDetial(this.defauleId).subscribe (
      (response) => {
        this.senderResponse = response;
        this.pay.bankCountrySender = this.senderResponse.bankCountry;
        this.pay.senderAcctNo = this.senderResponse.acctNo;
        this.pay.bankNameSender = this.senderResponse.bankName;
        console.log(this.senderResponse)
      }
    );
    
    }

    getRece() {
      this.service.getSenderDetial(this.pay.eduidRecevier).subscribe(
        (respon)=>{
          this.recevierResponse = respon;
          this.pay.recevierAcctNo = this.recevierResponse.acctNo;
          this.pay.bankNameReciver = this.recevierResponse.bankName;
          this.pay.bankCountryReciver  = this.recevierResponse.bankCountry;
        }
      );
    }
  }


