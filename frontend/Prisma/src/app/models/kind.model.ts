export class Kind {
    id: number;
    voornaam : string;
    achternaam:string;
    geslacht:string;


  constructor(id: number, voornaam: string, achternaam: string, geslacht: string) {
    this.id = id;
    this.voornaam = voornaam;
    this.achternaam = achternaam;
    this.geslacht = geslacht;
  }
}



