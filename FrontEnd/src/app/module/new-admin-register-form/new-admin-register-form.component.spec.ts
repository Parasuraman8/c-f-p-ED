import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewAdminRegisterFormComponent } from './new-admin-register-form.component';

describe('NewAdminRegisterFormComponent', () => {
  let component: NewAdminRegisterFormComponent;
  let fixture: ComponentFixture<NewAdminRegisterFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [NewAdminRegisterFormComponent]
    });
    fixture = TestBed.createComponent(NewAdminRegisterFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
