import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormBuilder} from "@angular/forms";
import {MentaleFuncties} from "../../../models/mentaleFuncties/mentale-functies.model";
import {Subfunctie} from "../../../models/subfunctie.model";
import {TrajectService} from "../../../services/traject.service";

@Component({
  selector: 'app-mentale-functies',
  templateUrl: './mentale-functies.component.html',
  styleUrls: ['./mentale-functies.component.css']
})
export class MentaleFunctiesComponent implements OnInit {

  @Output() hoofdfunctieIndex = new EventEmitter<number>();

  //Centrale Coherentie form
  vragenCC = this._formBuilder.group({
    gerichtOpDetail: false,
    moeizaamGeheelZien: false,
    vaardighedenContextAfhankelijk: false,
  });
  opmerkingCC!: string;
  antwoordenCC: Subfunctie = new Subfunctie('', '');


  //Executieve Functies form
  vragenEF = this._formBuilder.group({
    responsinhibitie: false,
    werkgeheugen: false,
    emotieRegulatie: false,
    volgehoudenAandacht: false,
    taakinitiatie: false,
    planning: false,
    organisatie: false,
    timemanagement: false,
    doelGerichtHandelen: false,
    flexibiliteit: false,
    metacognitie: false
  })
  opmerkingEF!: string;
  antwoordenEF: Subfunctie = new Subfunctie('', '');


  //Theory of Mind form
  vragenToM = this._formBuilder.group({
    letterlijkBegrijpenTaal: false,
    moeitePerspectiefname: false
  });
  opmerkingToM!: string;
  antwoordenToM: Subfunctie = new Subfunctie('', '');


  //Socio-emotionele ontwikkeling form
  vragenSocio = this._formBuilder.group({
    persoonlijkheid: false
  });
  opmerkingSocio!: string;
  antwoordenSocio: Subfunctie = new Subfunctie('', '');


  mentaleFunctie: MentaleFuncties = new MentaleFuncties(this.antwoordenCC, this.antwoordenEF, this.antwoordenToM, this.antwoordenSocio)

  constructor(private _formBuilder: FormBuilder, private trajectService: TrajectService) {
  }

  ngOnInit(): void {
  }

  saveData() {
    this.antwoordenCC.antwoorden = this.vragenCC.value
    this.antwoordenCC.opmerking = this.opmerkingCC

    this.antwoordenEF.antwoorden = this.vragenEF.value
    this.antwoordenEF.opmerking = this.opmerkingEF

    this.antwoordenToM.antwoorden = this.vragenToM.value
    this.antwoordenToM.opmerking = this.opmerkingToM

    this.antwoordenSocio.antwoorden = this.vragenSocio.value
    this.antwoordenSocio.opmerking = this.opmerkingSocio

    this.trajectService.currentTraject.groeipunten.mentaleFunctie = this.mentaleFunctie;
  }

  functieNavigatie(stap: number) {
    this.saveData()
    this.hoofdfunctieIndex.emit(stap)
  }

}
