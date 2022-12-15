import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-hoofdfunctie-indicatie',
  templateUrl: './hoofdfunctie-indicatie.component.html',
  styleUrls: ['./hoofdfunctie-indicatie.component.css']
})
export class HoofdfunctieIndicatieComponent implements OnInit {
  @Input() hoofdFunctie!: number;
  constructor() { }

  ngOnInit(): void {
  }

}
