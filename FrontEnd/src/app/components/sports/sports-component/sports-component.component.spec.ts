import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SportsComponentComponent } from './sports-component.component';

describe('SportsComponentComponent', () => {
  let component: SportsComponentComponent;
  let fixture: ComponentFixture<SportsComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SportsComponentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SportsComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
