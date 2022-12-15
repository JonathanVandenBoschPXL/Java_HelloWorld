export class KindProfiel{
  voornaam: string;
  geboortedatum: string;
  adres: string;
  school: string;
  klas: string;
  achternaam: string;
  geslacht: string;

  constructor(voornaam: string, geboortedatum: string, adres: string, school: string, klas: string, achternaam: string, geslacht: string) {
    this.voornaam = voornaam;
    this.geboortedatum = geboortedatum;
    this.adres = adres;
    this.school = school;
    this.klas = klas;
    this.achternaam = achternaam;
    this.geslacht = geslacht;
  }
}
