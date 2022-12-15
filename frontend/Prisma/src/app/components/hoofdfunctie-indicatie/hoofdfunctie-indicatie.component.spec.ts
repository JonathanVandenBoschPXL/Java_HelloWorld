import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HoofdfunctieIndicatieComponent } from './hoofdfunctie-indicatie.component';

describe('HoofdfunctieIndicatieComponent', () => {
  let component: HoofdfunctieIndicatieComponent;
  let fixture: ComponentFixture<HoofdfunctieIndicatieComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HoofdfunctieIndicatieComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HoofdfunctieIndicatieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
