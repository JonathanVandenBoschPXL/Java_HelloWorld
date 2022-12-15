import {Component, Input, OnInit} from '@angular/core';
import {Traject} from "../../models/traject.model";
import {ApiService} from "../../services/api.service";
import {TrajectResponse} from "../../models/TrajectResponseModels/traject-response.model";
import {empty} from "rxjs";
import {THREE} from "@angular/cdk/keycodes";
import {UserRol} from "../../models/TrajectResponseModels/user-rol";

@Component({
  selector: 'app-afgemaakt-traject-vergelijken',
  templateUrl: './afgemaakt-traject-vergelijken.component.html',
  styleUrls: ['./afgemaakt-traject-vergelijken.component.css']
})
export class AfgemaaktTrajectVergelijkenComponent implements OnInit {
  @Input() kindId!: string;
  @Input() trajectHuidig!: TrajectResponse;
  trajectenList!: Array<TrajectResponse>;
  trajectenFilterList!: Array<TrajectResponse>;
  geselecteerdTraject!: TrajectResponse;
  geselecteerd: boolean = false;
  gebruikerRollen: string[];

  constructor(private apiService: ApiService) {
    this.gebruikerRollen = Object.keys(UserRol);
  }

  ngOnInit(): void {

  }

  laadTrajecten() {
    if (this.trajectHuidig == null) {
      this.apiService.getAllTrajectenVanKind(this.kindId).subscribe(data => {
        this.trajectenList = data;
        this.trajectenFilterList = data;
      })
    } else {
      this.apiService.vindAlleTrajectenVanKindBehalveMeestRecent(this.kindId, String(this.trajectHuidig.id)).subscribe(data => {
        this.trajectenList = data;
        this.trajectenFilterList = data;
      })
    }
  }

  zetTrajectOmTeVergelijken(traject: TrajectResponse) {
    this.geselecteerdTraject = traject;
    this.geselecteerd = true;

  }

  trajectDeselecteren() {
    this.geselecteerd = false;
  }

  filterBijRol(rol:string){
    this.trajectenFilterList =  this.trajectenList.filter(traject => traject.user.rol === rol);
  }
  filterBijDatum(datum:string){
    this.trajectenFilterList = this.trajectenList.filter(traject => traject.datumLaatstAangepast == datum);
  }

  toonAlleTrajecten(){
    this.trajectenFilterList = this.trajectenList;
  }
  mijnTrajecten(){
    this.apiService.getTrajecten("1", this.kindId).subscribe(data => {
      this.trajectenFilterList = data.filter(traject => traject.id !== this.trajectHuidig.id);
      console.log(data)
    })
  }

}
