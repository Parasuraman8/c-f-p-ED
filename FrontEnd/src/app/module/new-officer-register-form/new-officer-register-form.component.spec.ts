import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewOfficerRegisterFormComponent } from './new-officer-register-form.component';

describe('NewOfficerRegisterFormComponent', () => {
  let component: NewOfficerRegisterFormComponent;
  let fixture: ComponentFixture<NewOfficerRegisterFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [NewOfficerRegisterFormComponent]
    });
    fixture = TestBed.createComponent(NewOfficerRegisterFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
