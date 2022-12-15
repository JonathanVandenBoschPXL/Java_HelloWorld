import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormBuilder} from "@angular/forms";
import {Subfunctie} from "../../../models/subfunctie.model";
import {TrajectService} from "../../../services/traject.service";

@Component({
  selector: 'app-beweging-functies',
  templateUrl: './beweging-functies.component.html',
  styleUrls: ['./beweging-functies.component.css']
})
export class BewegingFunctiesComponent implements OnInit {
  @Output() hoofdfunctieIndex = new EventEmitter<number>();

  vragen = this._formBuilder.group({
    motorischeVaardigheden: false,
    spierspanning: false,
    coordinatievermogen: false
  });
  opmerking!: string;
  bewegingfuncties: Subfunctie = new Subfunctie('', '');

  constructor(private _formBuilder: FormBuilder, private trajectService: TrajectService) {
  }

  ngOnInit(): void {
  }

  saveData() {
    this.bewegingfuncties.antwoorden = this.vragen.value;
    this.bewegingfuncties.opmerking = this.opmerking;
    this.trajectService.currentTraject.groeipunten.bewegingsFunctie = this.bewegingfuncties;
  }

  functieNavigatie(stap: number) {
    this.saveData()
    this.hoofdfunctieIndex.emit(stap)
  }

}
