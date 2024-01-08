import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OfficerPaymentComponent } from './officer-payment.component';

describe('OfficerPaymentComponent', () => {
  let component: OfficerPaymentComponent;
  let fixture: ComponentFixture<OfficerPaymentComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [OfficerPaymentComponent]
    });
    fixture = TestBed.createComponent(OfficerPaymentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
