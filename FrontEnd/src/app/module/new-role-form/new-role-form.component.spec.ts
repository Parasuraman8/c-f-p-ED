import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewRoleFormComponent } from './new-role-form.component';

describe('NewRoleFormComponent', () => {
  let component: NewRoleFormComponent;
  let fixture: ComponentFixture<NewRoleFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [NewRoleFormComponent]
    });
    fixture = TestBed.createComponent(NewRoleFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
