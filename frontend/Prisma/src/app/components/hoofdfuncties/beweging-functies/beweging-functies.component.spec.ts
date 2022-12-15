import { DebugNode, NO_ERRORS_SCHEMA } from '@angular/core';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormBuilder } from '@angular/forms';
import { TrajectService } from 'src/app/services/traject.service';

import { BewegingFunctiesComponent } from './beweging-functies.component';

describe('BewegingFunctiesComponent', () => {
  let fixture: ComponentFixture<BewegingFunctiesComponent>;
  let instance: DebugNode['componentInstance'];

  beforeEach(() => {

    TestBed.configureTestingModule({
      declarations: [BewegingFunctiesComponent],
      providers: [
        { provide: FormBuilder, TrajectService },
      ],
      schemas: [NO_ERRORS_SCHEMA]
    });

    fixture = TestBed.createComponent(BewegingFunctiesComponent);
    instance = fixture.debugElement.componentInstance;
    fixture.detectChanges();
  })

  describe('saveData', () => {
    it('sets component fields to correct values', () => {
      instance.vragen = instance._formBuilder.group({
        motorischeVaardigheden: false,
        spierspanning: true,
        coordinatievermogen: false
      });
      instance.trajectService.maakNieuwTraject();
      instance.opmerking = '';
      instance.bewegingfuncties.opmerking = 'opmerking';

      instance.saveData();
      expect(instance.bewegingfuncties.antwoorden).toEqual(instance.vragen.value);
      expect(instance.bewegingfuncties.opmerking).toEqual(instance.opmerking);
      expect(instance.trajectService.currentTraject.groeipunten.bewegingsFunctie).toEqual(instance.bewegingfuncties);
    });
  });

  describe('functieNavigatie', () => {
    it('calls saveData', () => {
      spyOn(instance, 'saveData');
      instance.functieNavigatie();

      expect(instance.saveData).toHaveBeenCalled();
    });

    it('emits hoofdFunctieIndex with step', () => {
      spyOn(instance.hoofdfunctieIndex, 'emit');
      spyOn(instance, 'saveData');
      let step: number = 1;
      instance.functieNavigatie(step);
      expect(instance.hoofdfunctieIndex.emit).toHaveBeenCalledWith(step);
    })
  })

});
