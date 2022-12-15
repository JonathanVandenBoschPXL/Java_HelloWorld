import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-hoofdfunctie',
  templateUrl: './hoofdfunctie.component.html',
  styleUrls: ['./hoofdfunctie.component.css']
})
export class HoofdfunctieComponent implements OnInit {
  @Input() hoofdFunctie!: number;
  @Output() hoofdfunctieIndex = new EventEmitter<number>();
  constructor() { }

  ngOnInit(): void {
  }
  functieNavigatie(stap: number){
    this.hoofdfunctieIndex.emit(stap)
  }
}
