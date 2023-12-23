import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EdoHomeComponent } from './edo-home.component';

describe('EdoHomeComponent', () => {
  let component: EdoHomeComponent;
  let fixture: ComponentFixture<EdoHomeComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EdoHomeComponent]
    });
    fixture = TestBed.createComponent(EdoHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
