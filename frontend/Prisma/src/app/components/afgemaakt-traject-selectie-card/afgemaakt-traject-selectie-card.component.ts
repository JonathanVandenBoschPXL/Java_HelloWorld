import {Component, Input, OnInit} from '@angular/core';
import {TrajectResponse} from "../../models/TrajectResponseModels/traject-response.model";

@Component({
  selector: 'app-afgemaakt-traject-selectie-card',
  templateUrl: './afgemaakt-traject-selectie-card.component.html',
  styleUrls: ['./afgemaakt-traject-selectie-card.component.css']
})
export class AfgemaaktTrajectSelectieCardComponent implements OnInit {
  @Input() traject!: TrajectResponse;
  constructor() { }

  ngOnInit(): void {
  }

}
