import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserHistroyComponent } from './user-histroy.component';

describe('UserHistroyComponent', () => {
  let component: UserHistroyComponent;
  let fixture: ComponentFixture<UserHistroyComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UserHistroyComponent]
    });
    fixture = TestBed.createComponent(UserHistroyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
