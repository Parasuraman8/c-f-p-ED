import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-payment-send',
  templateUrl: './user-payment-send.component.html',
  styleUrls: ['./user-payment-send.component.css']
})
export class UserPaymentSendComponent {

  constructor(private router : Router) {}

  BackPage() {
    this.router.navigate(['/home/Edu-page/User-Payment']);
  }

}
