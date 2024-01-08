import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserPaymentSendComponent } from './user-payment-send.component';

describe('UserPaymentSendComponent', () => {
  let component: UserPaymentSendComponent;
  let fixture: ComponentFixture<UserPaymentSendComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UserPaymentSendComponent]
    });
    fixture = TestBed.createComponent(UserPaymentSendComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
