import {AntwoordResponse} from "./antwoord-response.model";

export class SubFunctieResponse {
  naam: string;
  opmerking: string;
  prioriteit: boolean;
  antwoorden: AntwoordResponse[];


  constructor(naam: string, opmerking: string, prioriteit: boolean, antwoorden: AntwoordResponse[]) {
    this.naam = naam;
    this.opmerking = opmerking;
    this.prioriteit = prioriteit;
    this.antwoorden = antwoorden;
  }
}
