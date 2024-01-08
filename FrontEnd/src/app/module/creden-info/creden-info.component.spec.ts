import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CredenInfoComponent } from './creden-info.component';

describe('CredenInfoComponent', () => {
  let component: CredenInfoComponent;
  let fixture: ComponentFixture<CredenInfoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CredenInfoComponent]
    });
    fixture = TestBed.createComponent(CredenInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
