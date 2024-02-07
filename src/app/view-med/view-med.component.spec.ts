import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewMedComponent } from './view-med.component';

describe('ViewMedComponent', () => {
  let component: ViewMedComponent;
  let fixture: ComponentFixture<ViewMedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewMedComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewMedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
