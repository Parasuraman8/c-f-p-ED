import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OfficerInfoComponent } from './officer-info.component';

describe('OfficerInfoComponent', () => {
  let component: OfficerInfoComponent;
  let fixture: ComponentFixture<OfficerInfoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [OfficerInfoComponent]
    });
    fixture = TestBed.createComponent(OfficerInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
