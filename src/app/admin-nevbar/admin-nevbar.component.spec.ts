import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminNevbarComponent } from './admin-nevbar.component';

describe('AdminNevbarComponent', () => {
  let component: AdminNevbarComponent;
  let fixture: ComponentFixture<AdminNevbarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminNevbarComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminNevbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
