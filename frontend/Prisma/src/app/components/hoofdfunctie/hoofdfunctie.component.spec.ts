import { DebugNode, NO_ERRORS_SCHEMA } from '@angular/core';
import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HoofdfunctieComponent } from './hoofdfunctie.component';

describe('HoofdfunctieComponent', () => {
  let fixture: ComponentFixture<HoofdfunctieComponent>;
  let instance: DebugNode['componentInstance']

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [HoofdfunctieComponent],
      schemas: [NO_ERRORS_SCHEMA]
    })
      .compileComponents();

    fixture = TestBed.createComponent(HoofdfunctieComponent);
    instance = fixture.debugElement.componentInstance;
    fixture.detectChanges();
  });

  describe('functieNavigatie', () => {
    it('should emit hoofdFunctieIndex with step', () => {
      spyOn(instance.hoofdfunctieIndex, 'emit');
      let step: number = 1;
      instance.functieNavigatie(step);
      expect(instance.hoofdfunctieIndex.emit).toHaveBeenCalledWith(step);
    })
  })
});
