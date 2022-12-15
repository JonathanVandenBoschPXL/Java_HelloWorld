import {SubFunctieResponse} from "./sub-functie-response.model";

export class Functie {
  naam: string;
  subfunctie: SubFunctieResponse[];

  constructor(naam: string, subfunctie: SubFunctieResponse[]) {
    this.naam = naam;
    this.subfunctie = subfunctie;
  }
}
