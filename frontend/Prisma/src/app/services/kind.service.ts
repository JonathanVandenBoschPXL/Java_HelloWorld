import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {environment} from 'src/environments/environment';
import {Kind} from "../models/kind.model";
import {KindProfiel} from "../models/KindProfiel";
import { TokenService } from './token.service';

@Injectable({
  providedIn: 'root'
})
export class KindService {
  headers!: HttpHeaders;

  constructor(private http: HttpClient, private tokenService: TokenService) {
    this.headers = new HttpHeaders({
      Authorization: "Bearer " + this.tokenService.accessToken
    })
  }

  getKinderen(userId: string): Observable<Kind[]> {
    return this.http.get<Kind[]>(environment.apiUrl + `user/${userId}/kinderen`, {'headers': this.headers});
  }

  getKindProfiel(kindId: string): Observable<KindProfiel> {
    return this.http.get<KindProfiel>(environment.apiUrl + `kind/${kindId}`, {'headers': this.headers});
  }
}
