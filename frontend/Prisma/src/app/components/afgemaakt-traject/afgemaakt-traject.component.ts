import {Component, OnInit} from '@angular/core';
import {ApiService} from "../../services/api.service";
import {TrajectResponse} from "../../models/TrajectResponseModels/traject-response.model";
import {TrajectService} from "../../services/traject.service";
import {Router} from "@angular/router";
import { TokenService } from 'src/app/services/token.service';


@Component({
  selector: 'app-afgemaakt-traject',
  templateUrl: './afgemaakt-traject.component.html',
  styleUrls: ['./afgemaakt-traject.component.css']
})
export class AfgemaaktTrajectComponent implements OnInit {
  trajectenLijst: Array<TrajectResponse> = [];
  meestRecentTraject!: TrajectResponse;
  standaardUserId$ = this.tokenService.getUserId();
  kindId$: string = JSON.parse(sessionStorage.getItem('kindId')!);
  eigenTrajectAanwezig: boolean = false;

  constructor(private apiService: ApiService, private trajectService: TrajectService, private router: Router, private tokenService: TokenService) {
  }

  ngOnInit(): void {
    this.laadTraject();
  }

  laadTraject() {
    this.apiService.getTrajecten('1', this.kindId$).subscribe(data => {
      this.trajectenLijst = data;
      if (this.trajectenLijst.length > 0){
        this.zetMeestRecentTraject(data);
        this.eigenTrajectAanwezig = true;
      }
    });
  }

  zetMeestRecentTraject(trajecten: Array<TrajectResponse>) {
    this.meestRecentTraject = trajecten[0];
    console.log(this.meestRecentTraject)
  }
  maakNieuwTraject() {
    this.trajectService.maakNieuwTraject();
    this.router.navigate(['/situering']);
  }
}

