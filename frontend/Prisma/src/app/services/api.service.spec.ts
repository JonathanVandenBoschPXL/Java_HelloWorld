import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

import { ApiService } from './api.service';
import { environment } from 'src/environments/environment';

describe('TrajectService', () => {
  let httpTestingController: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [ApiService]});
      httpTestingController = TestBed.inject(HttpTestingController);
  });

  describe('checkVoorBestaandeTrajecten', () => {
    it('should return the correct TrajectAanwezig object', () => {
      const apiService = TestBed.inject(ApiService);
      apiService.checkVoorBestaandeTrajecten('1', '1').subscribe(
        trajectaanwezig => {
          expect(trajectaanwezig.kindHeeftTrajecten).toBeTrue();
          expect(trajectaanwezig.userHeeftTrajectenVanDitKind).toBeTrue();
        }
      );
      const req = httpTestingController.expectOne(environment.apiUrl + 'traject/1/kind/1');
      req.flush({kindHeeftTrajecten: true, userHeeftTrajectenVanDitKind: true});
      httpTestingController.verify();
    })
  })
});
