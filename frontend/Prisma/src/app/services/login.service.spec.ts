import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { TestBed } from '@angular/core/testing';
import { environment } from 'src/environments/environment';
import { Login } from '../models/login';

import { LoginService } from './login.service';

describe('LoginService', () => {
  let httpTestingController: HttpTestingController;
  let loginRequest: Login;
  let accessToken: string;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [LoginService]
    });
    httpTestingController = TestBed.inject(HttpTestingController);
    loginRequest = new Login('email', 'wachtwoord');
    accessToken = "accesstoken";
  });

  describe('login', () => {
    it('should post to login endpoint', () => {
      const loginService = TestBed.inject(LoginService);
      loginService.login(loginRequest).subscribe(data => {
        expect(data).not.toEqual("invalid_grant");
        expect(data).toEqual(accessToken);
      });

      const req = httpTestingController.expectOne(environment.apiUrl + "login");
      req.flush(accessToken);
      httpTestingController.verify();
    })
  })

});
