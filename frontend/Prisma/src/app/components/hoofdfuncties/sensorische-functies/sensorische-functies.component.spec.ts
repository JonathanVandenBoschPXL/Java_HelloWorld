import { DebugNode, NO_ERRORS_SCHEMA } from '@angular/core';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormBuilder } from '@angular/forms';
import { TrajectService } from 'src/app/services/traject.service';

import { SensorischeFunctiesComponent } from './sensorische-functies.component';

describe('SensorischeFunctiesComponent', () => {
  let fixture: ComponentFixture<SensorischeFunctiesComponent>;
  let instance: DebugNode['componentInstance'];

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SensorischeFunctiesComponent ],
      providers: [FormBuilder, TrajectService],
      schemas: [NO_ERRORS_SCHEMA]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SensorischeFunctiesComponent);
    instance = fixture.debugElement.componentInstance;
    fixture.detectChanges();
  });

  describe('saveData', () => {
    it('sets component fields to correct values', () => {
      instance.vragen = instance._formBuilder.group({
        overprikkeling: false,
        onderprikkeling: false,
        visueleDenkers: false
      });
      instance.trajectService.maakNieuwTraject();
      instance.opmerking = '';
      instance.sensorischeFuncties.opmerking = 'opmerking';

      instance.saveData();
      expect(instance.sensorischeFuncties.antwoorden).toEqual(instance.vragen.value);
      expect(instance.sensorischeFuncties.opmerking).toEqual(instance.opmerking);
      expect(instance.trajectService.currentTraject.groeipunten.sensorischeFunctie).toEqual(instance.sensorischeFuncties);
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
  });


});
