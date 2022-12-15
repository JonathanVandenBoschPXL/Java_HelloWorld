import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormBuilder } from '@angular/forms';

import { MentaleFunctiesComponent } from './mentale-functies.component';

describe('MentaleFunctiesComponent', () => {
  let component: MentaleFunctiesComponent;
  let fixture: ComponentFixture<MentaleFunctiesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MentaleFunctiesComponent ],
      providers: [FormBuilder]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MentaleFunctiesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
