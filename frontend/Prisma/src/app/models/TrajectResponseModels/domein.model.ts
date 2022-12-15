import {Functie} from "./functie.model";

export class Domein {
  functie: Functie[];
  kleur: string;
  naam: string;

  constructor(functie: Functie[], kleur: string, naam: string) {
    this.functie = functie;
    this.kleur = kleur;
    this.naam = naam;
  }
}
