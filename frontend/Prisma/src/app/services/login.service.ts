import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, of } from 'rxjs';
import { Login } from '../models/login';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  accessToken: String;

  constructor(private http: HttpClient) {
    this.accessToken = "";
   }

  login(loginRequest: Login){
    return this.http.post<String>("http://localhost:7000/api/login", loginRequest);
  }
}
