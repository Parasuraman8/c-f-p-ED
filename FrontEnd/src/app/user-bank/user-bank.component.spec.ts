import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserBankComponent } from './user-bank.component';

describe('UserBankComponent', () => {
  let component: UserBankComponent;
  let fixture: ComponentFixture<UserBankComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UserBankComponent]
    });
    fixture = TestBed.createComponent(UserBankComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
