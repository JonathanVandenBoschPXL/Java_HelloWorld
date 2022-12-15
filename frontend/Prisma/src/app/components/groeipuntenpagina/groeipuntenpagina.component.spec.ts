import { DebugNode, NO_ERRORS_SCHEMA } from '@angular/core';
import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GroeipuntenpaginaComponent } from './groeipuntenpagina.component';

describe('GroeipuntenpaginaComponent', () => {
  let fixture: ComponentFixture<GroeipuntenpaginaComponent>;
  let instance: DebugNode['componentInstance'];
  let expectedHuidigeHoofdFunctie: string[];
  let expectedHoofdfunctieIndex: number;

  beforeEach(() => {
    expectedHuidigeHoofdFunctie = ["mentaal", "sensorisch", "beweging"];
    expectedHoofdfunctieIndex = 0;
    TestBed.configureTestingModule({
      declarations: [GroeipuntenpaginaComponent],
      schemas: [NO_ERRORS_SCHEMA]
    })

    fixture = TestBed.createComponent(GroeipuntenpaginaComponent);
    instance = fixture.debugElement.componentInstance;
    fixture.detectChanges();
  });

  describe('ngOnInit', () => {
    it('sets huidigeHoofdFunctie to correct values', () => {
      expect(instance.huidigeHoofdFunctie).toEqual(expectedHuidigeHoofdFunctie);
      expect(instance.hoofdfunctieIndex).toEqual(expectedHoofdfunctieIndex);
    });
  });

  describe('functieNavigatie', () => {
    it('moves index one step up if index and step is smaller than length of function -1 and greater or equal 0', () => {
      instance.functieNavigatie(1);
      expect(instance.hoofdfunctieIndex).toEqual(1);
    });

    it('does not move index one step up if step is bigger than length of function - 1', () => {
      instance.functieNavigatie(3);
      expect(instance.hoofdfunctieIndex).toEqual(expectedHoofdfunctieIndex);
    })
  })

});
