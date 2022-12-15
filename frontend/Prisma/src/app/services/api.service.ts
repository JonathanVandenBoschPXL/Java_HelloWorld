import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {TrajectAanwezig} from "../models/TrajectAanwezig";
import {Traject} from "../models/traject.model";
import {TrajectResponse} from "../models/TrajectResponseModels/traject-response.model";
import {Observable} from "rxjs";
import { TokenService } from './token.service';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  headers!: HttpHeaders;

  constructor(private http: HttpClient, private tokenService: TokenService) {
    this.headers = new HttpHeaders({
      Authorization: "Bearer " + this.tokenService.accessToken
    })
   }

  checkVoorBestaandeTrajecten(userId: string, kindId: string){
    return this.http.get<TrajectAanwezig>(environment.apiUrl + `traject/${userId}/kind/${kindId}`, {'headers': this.headers});
  }
  trajectOpslaan(userId: string, kindId: string, newTraject: Traject):Observable<Traject> {
    return this.http.post<Traject>(environment.apiUrl + `traject/${userId}/kind/${kindId}`, newTraject, {'headers': this.headers});
  }
  getTrajecten(userId: string, kindId: string){
    return this.http.get<Array<TrajectResponse>>(environment.apiUrl + `traject/${userId}/kind/${kindId}/traject`, {'headers': this.headers});
  }
  vindAlleTrajectenVanKindBehalveMeestRecent(kindId: string, recentTrajectId: string){
    return this.http.get<Array<TrajectResponse>>(environment.apiUrl + `traject/recentTraject/${recentTrajectId}/kind/${kindId}/allTrajecten`, {'headers': this.headers});
  }
  getAllTrajectenVanKind(kindId: string){
    return this.http.get<Array<TrajectResponse>>(environment.apiUrl + `traject/kind/${kindId}/allTrajecten`, {'headers': this.headers});
  }
}
