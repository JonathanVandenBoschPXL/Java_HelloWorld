export class AntwoordResponse {
  ingevuld: boolean;
  naam: string;

  constructor(ingevuld: boolean, naam: string) {
    this.ingevuld = ingevuld;
    this.naam = naam;
  }
}
