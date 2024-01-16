import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OfficerManagerComponent } from './officer-manager.component';

describe('OfficerManagerComponent', () => {
  let component: OfficerManagerComponent;
  let fixture: ComponentFixture<OfficerManagerComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [OfficerManagerComponent]
    });
    fixture = TestBed.createComponent(OfficerManagerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
