import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ForgotUserCredentialsComponent } from './forgot-user-credentials.component';

describe('ForgotUserCredentialsComponent', () => {
  let component: ForgotUserCredentialsComponent;
  let fixture: ComponentFixture<ForgotUserCredentialsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ForgotUserCredentialsComponent]
    });
    fixture = TestBed.createComponent(ForgotUserCredentialsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
