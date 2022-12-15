import {Injectable} from '@angular/core';
import {Traject} from "../models/traject.model";
import {Subfunctie} from "../models/subfunctie.model";
import {MentaleFuncties} from "../models/mentaleFuncties/mentale-functies.model";
import {Groeipunten} from "../models/groeipunten.model";
import {Situering} from "../models/situering.model";

@Injectable({
  providedIn: 'root'
})
export class TrajectService {
  currentTraject!: Traject;

  constructor() {
  }

  async maakNieuwTraject(){
    let centraleCoherentie = new Subfunctie('', '');
    let executieveFuncties = new Subfunctie('', '');
    let theoryfMind = new Subfunctie('', '');
    let socioEmotioneleOntwikkeling = new Subfunctie('', '');
    let bewegingFuncties = new Subfunctie('', '');
    let sensorischeFucties = new Subfunctie('', '');
    let mentaleFuncties = new MentaleFuncties(centraleCoherentie, executieveFuncties, theoryfMind, socioEmotioneleOntwikkeling);
    let groeipunten = new Groeipunten(mentaleFuncties, sensorischeFucties, bewegingFuncties);
    let situering = new Situering('', '');
    this.currentTraject = new Traject(situering, groeipunten);
  }

}
