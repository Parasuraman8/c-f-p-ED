import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManageOfficerComponent } from './manage-officer.component';

describe('ManageOfficerComponent', () => {
  let component: ManageOfficerComponent;
  let fixture: ComponentFixture<ManageOfficerComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ManageOfficerComponent]
    });
    fixture = TestBed.createComponent(ManageOfficerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
