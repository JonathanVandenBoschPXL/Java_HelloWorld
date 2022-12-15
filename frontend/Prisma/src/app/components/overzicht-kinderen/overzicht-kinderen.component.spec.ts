import { NO_ERRORS_SCHEMA, DebugNode } from '@angular/core';
import { ComponentFixture, fakeAsync, TestBed, tick } from '@angular/core/testing';
import { Kind } from 'src/app/models/kind.model';
import { KindService } from 'src/app/services/kind.service';
import { Observable, of, take } from 'rxjs';

import { OverzichtKinderenComponent } from './overzicht-kinderen.component';
import { TokenService } from 'src/app/services/token.service';

describe('OverzichtKinderenComponent', () => {
  let fixture: ComponentFixture<OverzichtKinderenComponent>;
  let mockKindService: jasmine.SpyObj<any>;
  let mockTokenService: jasmine.SpyObj<any>;
  let instance: DebugNode['componentInstance'];

  beforeEach(() => {
    mockKindService = jasmine.createSpyObj(['getKinderen']);
    mockTokenService = jasmine.createSpyObj(['getUserId'])
    TestBed.configureTestingModule({
      declarations: [OverzichtKinderenComponent],
      providers: [
        { provide: KindService, useValue: mockKindService },
        { provide: TokenService, useValue: mockTokenService}
      ],
      schemas: [NO_ERRORS_SCHEMA]
    })

    fixture = TestBed.createComponent(OverzichtKinderenComponent);
    instance = fixture.debugElement.componentInstance;
    fixture.detectChanges();
  });

  describe('ngOnInit', () => {
    it('should fill kinderenList with kindService', () => {
      let kind: Kind = new Kind(0, '', '', '');
      let kind2: Kind = new Kind(1, '', '', '');
      let kindList: Kind[] = [kind, kind2];
      mockTokenService
      mockKindService.getKinderen.and.returnValue(of(kindList));

      instance.ngOnInit();

      instance.kinderenList$.subscribe((response: any[]) => {
        let kindResponse: any[] = response;
        expect(kindResponse).toEqual(kindList);
      });

      expect(mockKindService.getKinderen).toHaveBeenCalledWith(instance.standaardUserId$);
    });
  });
});
