import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { credential } from 'src/app/comman/credential';

@Component({
  selector: 'app-payment-info',
  templateUrl: './payment-info.component.html',
  styleUrls: ['./payment-info.component.css']
})
export class PaymentInfoComponent {

  constructor(private storage : credential,private router:Router) {}

  Back() {
    if(this.storage.getRole()=='EDA') {
      this.router.navigate(['/home/Eda-page/Manager/Manage-Payment']);
    } else {
      this.router.navigate(['/home/Edo-page/officer-manager/Manage-Payment']);
    }
  }

}
