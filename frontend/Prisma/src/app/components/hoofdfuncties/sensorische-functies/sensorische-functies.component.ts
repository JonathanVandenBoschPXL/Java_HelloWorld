import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormBuilder} from "@angular/forms";
import {Subfunctie} from "../../../models/subfunctie.model";
import {TrajectService} from "../../../services/traject.service";

@Component({
  selector: 'app-sensorische-functies',
  templateUrl: './sensorische-functies.component.html',
  styleUrls: ['./sensorische-functies.component.css']
})
export class SensorischeFunctiesComponent implements OnInit {
  @Output() hoofdfunctieIndex = new EventEmitter<number>();
  vragen = this._formBuilder.group({
    overprikkeling: false,
    onderprikkeling: false,
    visueleDenkers: false
  });
  opmerking!: string;
  sensorischeFuncties: Subfunctie = new Subfunctie('', '');


  constructor(private _formBuilder: FormBuilder, private trajectService: TrajectService) {
  }

  ngOnInit(): void {
  }

  saveData() {
    this.sensorischeFuncties.antwoorden = this.vragen.value;
    this.sensorischeFuncties.opmerking = this.opmerking;
    this.trajectService.currentTraject.groeipunten.sensorischeFunctie = this.sensorischeFuncties;
  }

  functieNavigatie(stap: number) {
    this.saveData()
    this.hoofdfunctieIndex.emit(stap)
  }
}
