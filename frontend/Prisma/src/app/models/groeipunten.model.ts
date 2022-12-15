import {MentaleFuncties} from "./mentaleFuncties/mentale-functies.model";
import {Subfunctie} from "./subfunctie.model";

export class Groeipunten {
  mentaleFunctie: MentaleFuncties;
  sensorischeFunctie: Subfunctie;
  bewegingsFunctie: Subfunctie;


  constructor(mentaleFunctie: MentaleFuncties, sensorischeFunctie: Subfunctie, bewegingsFunctie: Subfunctie) {
    this.mentaleFunctie = mentaleFunctie;
    this.sensorischeFunctie = sensorischeFunctie;
    this.bewegingsFunctie = bewegingsFunctie;
  }
}
