import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewRegisterFormComponent } from './new-register-form.component';

describe('NewRegisterFormComponent', () => {
  let component: NewRegisterFormComponent;
  let fixture: ComponentFixture<NewRegisterFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [NewRegisterFormComponent]
    });
    fixture = TestBed.createComponent(NewRegisterFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
