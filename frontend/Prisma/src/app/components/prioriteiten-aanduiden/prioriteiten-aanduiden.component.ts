import {Component, OnInit} from '@angular/core';
import {Traject} from "../../models/traject.model";
import {Router} from "@angular/router";
import {ApiService} from "../../services/api.service";
import {ToastrService} from "ngx-toastr";
import {TrajectService} from "../../services/traject.service";
import {AntwoordResponse} from "../../models/TrajectResponseModels/antwoord-response.model";

@Component({
  selector: 'app-prioriteiten-aanduiden',
  templateUrl: './prioriteiten-aanduiden.component.html',
  styleUrls: ['./prioriteiten-aanduiden.component.css']
})
export class PrioriteitenAanduidenComponent implements OnInit {
  dataTraject!: Traject;
  userId: string = '1';
  kindId!: string;
  groeipuntenAanwezig!: boolean;

  constructor(private router: Router, private apiService: ApiService, private trajectService: TrajectService, private toaster: ToastrService) {
  }

  ngOnInit(): void {
    this.dataTraject = this.trajectService.currentTraject;
    this.kindId = JSON.parse(sessionStorage.getItem('kindId')!);


  }

  zetPrioriteit(subFunctie: string) {
    switch (subFunctie) {
      case 'CC': {
        this.dataTraject.groeipunten.mentaleFunctie.centraleCoherentie.prioriteit = !this.dataTraject.groeipunten.mentaleFunctie.centraleCoherentie.prioriteit;
        break;
      }
      case 'EF': {
        this.dataTraject.groeipunten.mentaleFunctie.executieveFuncties.prioriteit = !this.dataTraject.groeipunten.mentaleFunctie.executieveFuncties.prioriteit;
        break;
      }
      case 'ToM': {
        this.dataTraject.groeipunten.mentaleFunctie.theoryOfMind.prioriteit = !this.dataTraject.groeipunten.mentaleFunctie.theoryOfMind.prioriteit;
        break;
      }
      case 'Socio': {
        this.dataTraject.groeipunten.mentaleFunctie.socioEmotioneleOntwikkeling.prioriteit = !this.dataTraject.groeipunten.mentaleFunctie.socioEmotioneleOntwikkeling.prioriteit;
        break;
      }
      case 'SF': {
        this.dataTraject.groeipunten.sensorischeFunctie.prioriteit = !this.dataTraject.groeipunten.sensorischeFunctie.prioriteit;
        break;
      }
      case 'Beweging': {
        this.dataTraject.groeipunten.bewegingsFunctie.prioriteit = !this.dataTraject.groeipunten.bewegingsFunctie.prioriteit;
        break;
      }
    }
  }

  opslaanTraject() {
    this.apiService.trajectOpslaan(this.userId, this.kindId, this.dataTraject).subscribe();
    this.toaster.info("opgeslagen");
    this.router.navigate([`/profielkind/${this.kindId}`]);
  }

  zetGroeipuntenAanwezig(subFunctie: string):boolean {
    let subfunctieAntwoorden: AntwoordResponse[] = [];
    this.groeipuntenAanwezig = false;
    switch (subFunctie) {
      case 'CC': {
        subfunctieAntwoorden  =  this.dataTraject.groeipunten.mentaleFunctie.centraleCoherentie.antwoorden;
        break;
      }
      case 'EF': {
        subfunctieAntwoorden = this.dataTraject.groeipunten.mentaleFunctie.executieveFuncties.antwoorden;
        break;
      }
      case 'ToM': {
        subfunctieAntwoorden = this.dataTraject.groeipunten.mentaleFunctie.theoryOfMind.antwoorden;
        break;
      }
      case 'Socio': {
        subfunctieAntwoorden = this.dataTraject.groeipunten.mentaleFunctie.socioEmotioneleOntwikkeling.antwoorden;
        break;
      }
      case 'SF': {
        subfunctieAntwoorden = this.dataTraject.groeipunten.sensorischeFunctie.antwoorden;
        break;
      }
      case 'Beweging': {
        subfunctieAntwoorden = this.dataTraject.groeipunten.bewegingsFunctie.antwoorden;
        break;
      }
    }
    Object.entries(subfunctieAntwoorden).forEach(([key, value], index) => {
      console.log(key, value, index);
      if (value){
        this.groeipuntenAanwezig = true;
      }
    });
    return this.groeipuntenAanwezig;
  }
}
