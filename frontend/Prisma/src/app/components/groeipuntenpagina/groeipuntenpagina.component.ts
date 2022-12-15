import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-groeipuntenpagina',
  templateUrl: './groeipuntenpagina.component.html',
  styleUrls: ['./groeipuntenpagina.component.css']
})
export class GroeipuntenpaginaComponent implements OnInit {
  huidigeHoofdFunctie!: string[];
  hoofdfunctieIndex!: number;

  constructor() { }

  ngOnInit(): void {
    this.huidigeHoofdFunctie = ["mentaal", "sensorisch", "beweging"]
    this.hoofdfunctieIndex = 0
  }
  functieNavigatie(stap: number){
    if (this.hoofdfunctieIndex + stap >= 0 && this.hoofdfunctieIndex + stap <= this.huidigeHoofdFunctie.length - 1 ){
      this.hoofdfunctieIndex += stap;
    }
  }

}
